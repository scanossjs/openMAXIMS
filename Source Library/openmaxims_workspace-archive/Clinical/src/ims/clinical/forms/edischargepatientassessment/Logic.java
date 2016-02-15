//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3362.18223)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.edischargepatientassessment;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

import ims.assessment.instantiation.vo.PatientAssessmentRefVo;
import ims.assessment.vo.PatientAssessmentDataVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.UserAssessmentLiteVoCollection;
import ims.assessment.vo.UserAssessmentVo;
import ims.assessment.vo.UserAssessmentWithServiceCollVo;
import ims.clinical.vo.DischargeDetailsWithAssessmentVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.vo.TemplateBoRefVo;
import ims.core.clinical.vo.ServiceRefVoCollection;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.PatientAssessmentInfoVo;
import ims.core.vo.PatientDocumentStatusVo;
import ims.core.vo.PatientDocumentStatusVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.enums.AuthoringLabelType;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.DocumentStatus;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PatientAssessmentStatusReason;
import ims.core.vo.lookups.PatientAssessmentStatusReasonCollection;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.UserAssessmentCategory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setDischargeDetails(null);
		form.getLocalContext().setbInitialised(null);
	}
	private void setInitialComponentsSettings()
	{
		form.customControlAuthoring().setIsRequiredPropertyToControls(Boolean.TRUE);
		form.customControlCompleted().setLabels(AuthoringLabelType.COMPLETING_COMPLETED);
		form.customControlCompleted().setIsRequiredPropertyToControls(Boolean.TRUE); //wdev-13949
	}
	
	private void loadStatusCombo(boolean removeNonCommenced)
	{
		//Status - has to load only parents
		form.cmbStatus().clear();
		PatientAssessmentStatusReasonCollection voColl = LookupHelper.getPatientAssessmentStatusReason(domain.getLookupService());
		for(int i = 0; voColl != null && i < voColl.size(); i++)
		{
			if(voColl.get(i).getParent() == null)
			{
				if(removeNonCommenced && voColl.get(i).equals(PatientAssessmentStatusReason.NOTCOMMENCED))
					continue;
				
				form.cmbStatus().newRow(voColl.get(i), voColl.get(i).toString());
			}
		}
	}
	
	private void manageReadOnly() 
	{
		if (form.getMode().equals(FormMode.VIEW))
			form.btnEdit().setVisible(!PatientAssessmentStatusReason.COMPLETED.equals(form.cmbStatus().getValue()));	//WDEV-12475
		else{
			form.setcustomControlAuthoringEnabled(isStatusCommenced());
			form.cmbStatus().setEnabled(true);
			form.cmbReason().setEnabled(true);
		}
		
		if (form.getLocalContext().getisReadonlyIsNotNull()
			&& form.getLocalContext().getisReadonly()
			&& form.getMode().equals(FormMode.VIEW))
			form.btnEdit().setVisible(false);
	}
	private boolean isStatusCommenced()
	{
		PatientAssessmentVo patientAssessment = null;
		if(form.getLocalContext().getDischargeDetails()!=null)
			patientAssessment = form.getLocalContext().getDischargeDetails().getPatientAssessment();
		if(patientAssessment == null)
			return false;
		
		return patientAssessment.getStatusIsNotNull() && patientAssessment.getStatus().equals(PatientAssessmentStatusReason.NOTCOMMENCED);
	}

	private boolean initializeCustomControl() 
	{
		UserAssessmentLiteVoCollection list = null;
		form.ccAssessment().clearComponent();
		if (form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull())
			list  = domain.listAssessments(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
		
		if (list != null && list.size() == 1)
		{
			form.getLocalContext().setChosenAssessment(domain.getUserAssessment(list.get(0)));
			loadAssessment();
		}
		else if (list != null && list.size() > 1)
		{
			if (form.getMode().equals(FormMode.EDIT))
			{
				form.getGlobalContext().Assessment.setAssessmentsForSpecialtyCollection(list);
				engine.open(form.getForms().Assessment.AssessmentsForSpecialty);
			}
		}
			
		if (list.size() == 0)
		{
			if (form.getGlobalContext().Core.getEpisodeofCareShortIsNotNull()
				&& form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialtyIsNotNull())
				engine.showMessage("No configured assessment for Specialty - " + form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty().toString() + ", was found.", "No Configured Assessment", MessageButtons.OK, MessageIcon.WARNING);
			else
				engine.showMessage("No configured assessment for the current Specialty was found.", "No Configured Assessment", MessageButtons.OK, MessageIcon.WARNING);
			
			form.setMode(FormMode.VIEW);
			manageReadOnly();
			return false;
		}
		form.getLocalContext().setisReadonly(false);
		
		return true;
	}

	
	private void loadAssessment()
	{
		if (form.getLocalContext().getChosenAssessmentIsNotNull())
		{
			PatientAssessmentVo newAssessment = new PatientAssessmentVo();
			PatientAssessmentDataVo assessmentData = new PatientAssessmentDataVo();	
			UserAssessmentVo userAssessment = form.getLocalContext().getChosenAssessment();
			assessmentData.setUserAssessment(userAssessment);
			assessmentData.setGroupQuestionWidth(userAssessment.getGroupQuestionWidth());
			newAssessment.setAssessmentData(assessmentData);	

			form.ccAssessment().setPatientAssessment(newAssessment, form.getMode().equals(FormMode.VIEW),PatientAssessmentInfoVo.getInstance(form.getGlobalContext().Core.getPatientShort()));
		}		
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		form.fireCustomControlValueChanged();
	}
	//wdev-13949
	protected String[] validateUIRules(String[] existingErrors)
	{
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(form.customControlCompleted().getValue() == null || form.customControlCompleted().getValue().getAuthoringHcp() == null || form.customControlCompleted().getValue().getAuthoringDateTime() == null)
		{
			listOfErrors.add("Completing HCP and Completed Date/Time are mandatory");
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		
		return result;
	}
	//----------
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.ccAssessment().getPatientAssessment() == null)
		{
			form.setMode(FormMode.VIEW);
			open();
			return;
		}
		
		//WDEV-12513
		if(PatientAssessmentStatusReason.COMPLETED.equals(form.cmbStatus().getValue()))
		{
			String[] errorsAssess = form.ccAssessment().validateData();
			errorsAssess = validateUIRules(errorsAssess); //wdev-13949
			if (errorsAssess != null)
			{
				engine.showErrors(errorsAssess);
				return;
			}
		}

		DischargeDetailsWithAssessmentVo ddVo = form.getLocalContext().getDischargeDetails();
		if (ddVo == null)
			ddVo = new DischargeDetailsWithAssessmentVo();
		
		if(uiErrors())
			return;
		
		PatientAssessmentVo voPatientAssessment = form.ccAssessment().getPatientAssessment();
		
		voPatientAssessment.setStatus(form.cmbStatus().getValue());
		voPatientAssessment.setStatusReason(form.cmbReason().getValue());
		
		voPatientAssessment.setAuthoringInformation(form.customControlAuthoring().getValue());
		setCompletedInformation(voPatientAssessment);
		
		ddVo.setPatientAssessment(form.ccAssessment().getPatientAssessment());
		
		if (ddVo.getPatientAssessmentIsNotNull() && ddVo.getPatientAssessment().getAuthoringInformation() == null)
		{
			AuthoringInformationVo voAuth = new AuthoringInformationVo();
			voAuth.setAuthoringDateTime(new DateTime());
			if(domain.getHcpUser() != null)
				voAuth.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
			ddVo.getPatientAssessment().setAuthoringInformation(voAuth);
			
		}
		
		//WDEV-11721
		if(ddVo.getPatientAssessmentIsNotNull() && ddVo.getPatientAssessment().getPatient() == null)
			ddVo.getPatientAssessment().setPatient(form.getGlobalContext().Core.getPatientShort());
		
		//WDEV-11526
		if(ddVo.getPatientAssessmentIsNotNull() && ddVo.getPatientAssessment().getEpisodeOfCare() == null)
			ddVo.getPatientAssessment().setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		
		if (ddVo.getPatientAssessmentIsNotNull() && ddVo.getPatientAssessment().getCareContext() == null)
			ddVo.getPatientAssessment().setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		try 
		{
			String[] errors = ddVo.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			ddVo = domain.saveDischargeDetails(ddVo);
			
			form.getLocalContext().setDischargeDetails(ddVo);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.setMode(FormMode.VIEW);//	WDEV-14773
			open();////	WDEV-14773
			form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);//	WDEV-14773
			form.fireCustomControlValueChanged();//	WDEV-14773
			return;//	WDEV-14773
		}
		
		//	WDEV-14773
		if(form.getLocalContext().getDischargeDetails() != null && form.getLocalContext().getDischargeDetails().getPatientAssessment() != null && PatientAssessmentStatusReason.COMPLETED.equals(form.getLocalContext().getDischargeDetails().getPatientAssessment().getStatus()) 
				&& form.getLocalContext().getDischargeDetails().getPatientAssessment().getAssessmentData() != null && form.getLocalContext().getDischargeDetails().getPatientAssessment().getAssessmentData().getUserAssessment() != null 
				&& form.getLocalContext().getDischargeDetails().getPatientAssessment().getAssessmentData().getUserAssessment().getAssociatedReport() != null
				&& Boolean.TRUE.equals(ConfigFlag.UI.SAVE_PATIENTDOCUMENT_ON_ASSESSMENTCOMPLETED.getValue()))
		{
			createAndSavePatientDocument();
		}
		
		form.setMode(FormMode.VIEW);
		open();
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		form.fireCustomControlValueChanged();
	}
	
	//	WDEV-14773
	private void createAndSavePatientDocument() 
	{
		if(form.getLocalContext().getDischargeDetails() == null || form.getLocalContext().getDischargeDetails().getPatientAssessment() == null)
			return;
		
		PatientAssessmentVo patientAssessment = (PatientAssessmentVo) form.getLocalContext().getDischargeDetails().getPatientAssessment().clone();
		
		StringBuilder path = new StringBuilder();
		path.append(ConfigFlag.GEN.PDF_STORE_PATH.getValue());
		
		if(!(path.toString().endsWith("/") || path.toString().endsWith("\\")))
			path.append("/");
		
		try
		{
			ServerDocumentVo serverDocument = null;
			
			if (patientAssessment.getAssessmentData().getUserAssessmentIsNotNull())
			{
				serverDocument = printPatientAssessment(patientAssessment, patientAssessment.getAssessmentData().getUserAssessment().getAssociatedReport(), null);
			}

			if (serverDocument == null)
				return;
			
			path.append(serverDocument.getFileName());

			// Create Patient Document VO
			PatientDocumentVo patientDocument = new PatientDocumentVo();
			patientDocument.setPatient(form.getGlobalContext().Core.getPatientShort());
			patientDocument.setEpisodeofCare(form.getGlobalContext().Core.getEpisodeofCareShort());
			patientDocument.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			//patientDocument.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			
			if (patientAssessment.getAssessmentData().getUserAssessmentIsNotNull())
			{
				patientDocument.setName(patientAssessment.getAssessmentData().getUserAssessment().getName());
			}
			
			patientDocument.setServerDocument(serverDocument);
			patientDocument.setCreationType(DocumentCreationType.GENERATED);
			
			if (patientAssessment.getAssessmentData().getUserAssessmentIsNotNull()
					&& UserAssessmentCategory.SAFETY_QUESTIONNAIRE.equals(patientAssessment.getAssessmentData().getUserAssessment().getCategory()))
			{
				patientDocument.setCategory(DocumentCategory.ASSESSMENT);
			}
			else
			{
				patientDocument.setCategory(DocumentCategory.ASSESSMENT);
			}
			
			patientDocument.setStatus(PreActiveActiveInactiveStatus.ACTIVE);
			patientDocument.setRecordingUser(domain.getMosUser() instanceof MemberOfStaffRefVo ? (MemberOfStaffRefVo) domain.getMosUser() : null);
			patientDocument.setRecordingDateTime(new DateTime());
			patientDocument.setAuthoringHCP(patientAssessment.getCompletedHCP());
			patientDocument.setAuthoringDateTime(patientAssessment.getCompletedDateTime());
			patientDocument.setResponsibleHCP(form.getGlobalContext().Core.getEpisodeofCareShort().getResponsibleHCP());
			patientDocument.setSpecialty(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
			patientDocument.setCorrespondenceStatus(DocumentStatus.COMPLETED);

			// Create a new PatientDocumentStatusVo
			PatientDocumentStatusVo status = new PatientDocumentStatusVo();
			status.setCorrespondenceStatus(DocumentStatus.COMPLETED);
			status.setRecordingUser(patientDocument.getRecordingUser());
			status.setRecordingDateTime(patientDocument.getRecordingDateTime());

			patientDocument.setCurrentDocumentStatus(status);
			patientDocument.setDocumentStatusHistory(new PatientDocumentStatusVoCollection());
			patientDocument.getDocumentStatusHistory().add(status);
			
			patientDocument.setDocumentDate(form.getGlobalContext().Core.getCurrentCareContext() != null ? form.getGlobalContext().Core.getCurrentCareContext().getStartDateTime().getDate() : patientDocument.getRecordingDateTime().getDate());//WDEV-13638
			
			if(patientAssessment.getAssessmentData().getUserAssessmentIsNotNull())
			{
				UserAssessmentVo assessVo = patientAssessment.getAssessmentData().getUserAssessment();
				if(assessVo != null)
				{
					if(assessVo.getCategoryIsNotNull() && assessVo.getCategory().equals(UserAssessmentCategory.SAFETY_QUESTIONNAIRE))
					{
						if(assessVo.getServicesIsNotNull() && assessVo.getServices().size() > 0)
						{
							ServiceRefVoCollection tempCol = new ServiceRefVoCollection();
							for(int i = 0; i < assessVo.getServices().size();i++ )
							{
								tempCol.add(assessVo.getServices().get(i));
							}
							patientDocument.setServices(tempCol);
							
						}
						
					}
				}
			}
			//----------
			// Update current Patient Assessment
			patientAssessment.setIsAssessmentDocumentSaved(Boolean.TRUE);

			// Validate Patient Assessment and Patient Document records
			String[] errors = patientDocument.validate();
			errors = patientAssessment.validate(errors);

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return;
			}

			domain.savePatientDocument(patientDocument, patientAssessment);
			
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.printStackTrace();
			
			// Attempt to delete uploaded document if stale occurs
			File file = new File(path.toString());
			if (file.exists() && file.canWrite())
				file.delete();
			
			return;
		}
	}
	
	//WDEV-14773
	private ServerDocumentVo printPatientAssessment(PatientAssessmentRefVo patientAssessment, TemplateBoRefVo templateReport, String printerName)
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String obj[] = domain.getReportAndTemplate(templateReport);
		
		if(obj == null)
		{
			engine.showMessage("I could not get the report and template linked to this assessment !");
			return null;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());

		client.addSeed(new SeedValue("PatientAssessment_id", patientAssessment.getID_PatientAssessment(), Integer.class));
		client.addSeed(new SeedValue("CareContext_id", form.getGlobalContext().Core.getCurrentCareContextIsNotNull() ? form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext() : null, Integer.class));
		//client.addSeed(new SeedValue("ClinicalContact_id", form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() ? form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact() : null, Integer.class));
		
		try
		{
			byte[] reportContent = client.buildReport(obj[0], obj[1], urlReportServer, QueryBuilderClient.PDF, printerName, 1);
			
			String fileName = generateName() + ".pdf";
			engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), reportContent, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue() + "\\");
			
			String path = null;
			
			int year  = new DateTime().getDate().getYear();
			int month = new DateTime().getDate().getMonth();
			int day   = new DateTime().getDate().getDay();
			
			if(fileName != null && fileName.length() > 0)
				path = year + "\\" + month + "\\" + day + "\\" + fileName;

			// Create Server document VO if uploads succeeds
			ServerDocumentVo document = new ServerDocumentVo();
			document.setFileName(path);
			document.setFileType(FileType.PDF);
			
			return document;
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return null;
		}
		catch (Exception e)
		{
			engine.showMessage("Could not upload file: " + e.getMessage());
			return null;
		}
	}
	
	//WDEV-14773
	private String generateName() 
	{
		String str = "";

		try
		{
			//Get Random Segment
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(prng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get CurrentTimeMillis() segment
			str += Long.toHexString(System.currentTimeMillis());
			while (str.length() < 12)
			{
				str = '0' + str;
			}

			//Get Random Segment
			SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
			str += Integer.toHexString(secondPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}

			//Get IdentityHash() segment
			str += Long.toHexString(System.identityHashCode((Object) this));
			while (str.length() < 8)
			{
				str = '0' + str;
			}
			//Get Third Random Segment
			byte bytes[] = new byte[16];
			SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
			thirdPrng.nextBytes(bytes);
			str += Integer.toHexString(thirdPrng.nextInt());
			while (str.length() < 8)
			{
				str = '0' + str;
			}
		}
		catch (java.security.NoSuchAlgorithmException ex)
		{
			ex.getMessage();
		}

		return str;
	}
	
	private boolean uiErrors()
	{
		ArrayList uiErrors = new ArrayList();
		if(form.cmbStatus().getValue() == null)
		{
			uiErrors.add("Status is mandatory");
		}

		String authErrors = form.customControlAuthoring().getErrors();
		if(authErrors != null)
			uiErrors.add(authErrors);
		
		if(form.cmbReason().getValue() != null && form.cmbReason().getValue().equals(PatientAssessmentStatusReason.COMPLETED))
		{
			String completedErrors = form.customControlCompleted().getErrors();
			if(completedErrors != null)
				uiErrors.add(completedErrors);
		}
			
		if(uiErrors.size() > 0)
		{
			String[] errors = new String[uiErrors.size()];
			uiErrors.toArray(errors);
			engine.showErrors(errors);
			return true;
		}
		
		return false;
	}
	private void setCompletedInformation(PatientAssessmentVo currentAssessment)
	{
		//Completed Assessment
		boolean isAssessmentCompleted = form.cmbStatus().getValue() != null && form.cmbStatus().getValue().equals(PatientAssessmentStatusReason.COMPLETED);
		if(isAssessmentCompleted)
		{
			AuthoringInformationVo completedData = form.customControlCompleted().getValue();
			if(completedData != null)
			{
				currentAssessment.setCompletedDateTime(completedData.getAuthoringDateTime());
				currentAssessment.setCompletedHCP(completedData.getAuthoringHcp());
			}
		}
	}
	private void enableConfirmingHCPComponent()
	{
		PatientAssessmentStatusReason parentLkp = form.cmbStatus().getValue();
		if(parentLkp != null && parentLkp.equals(PatientAssessmentStatusReason.COMPLETED))
		{
			boolean editMode = form.getMode().equals(FormMode.EDIT);
			if(editMode)
			{
				form.customControlCompleted().initializeComponent();
				form.setcustomControlCompletedEnabled(true);	
			}
		}
		else
		{
			boolean editMode = form.getMode().equals(FormMode.EDIT);
			if(editMode)
			{
				form.customControlCompleted().setValue(null);
				form.setcustomControlCompletedEnabled(false);
			}
		}
	}
	
	private void loadReasonCombo()
	{
		PatientAssessmentStatusReason parentLkp = form.cmbStatus().getValue();
		PatientAssessmentStatusReasonCollection voColl = LookupHelper.getPatientAssessmentStatusReason(domain.getLookupService());
		for(int i = 0; voColl != null && i < voColl.size(); i++)
		{
			if(voColl.get(i).getParent() != null && voColl.get(i).getParent().equals(parentLkp))
				form.cmbReason().newRow(voColl.get(i), voColl.get(i).toString());
		}
	}	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		if (form.getLocalContext().getDischargeDetailsIsNotNull()
			&& form.getLocalContext().getDischargeDetails().getPatientAssessment() == null)
		{
			if ( !initializeCustomControl())
				return;
			
			// WDEV-13973
			form.cmbStatus().setValue(PatientAssessmentStatusReason.INPROGRESS);
			// WDEV-14068
			cmbStatusValueChanged();
		}
		else
			form.ccAssessment().setPatientAssessment(form.getLocalContext().getDischargeDetails().getPatientAssessment(), form.getMode().equals(FormMode.VIEW));
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(true);
		form.cmbStatus().setEnabled(true);
		form.cmbReason().setEnabled(true);
		form.setcustomControlAuthoringEnabled(true);
		form.customControlAuthoring().initializeComponent();
		form.fireCustomControlValueChanged();
	}
	private void open() 
	{
		populateScreenFromData(domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext()));
		
		form.ccAssessment().setReadOnly(Boolean.TRUE);
		manageReadOnly();
	}
	//start WDEV-13946 
	private void clearData()
	{
		form.ccAssessment().clearComponent();
		form.cmbStatus().setValue(null);
		form.cmbReason().clear();
		form.customControlAuthoring().setValue(null);
		form.customControlCompleted().setValue(null);
	}
	//end
	
	private void populateScreenFromData(DischargeDetailsWithAssessmentVo dischargeDetails) 
	{
		clearData(); //WDEV-13946
		
		if (dischargeDetails == null)
			return;
		
		form.getLocalContext().setDischargeDetails(dischargeDetails);
		
		if (dischargeDetails.getPatientAssessmentIsNotNull())
		{
			form.ccAssessment().clearComponent();
			form.ccAssessment().setPatientAssessment(dischargeDetails.getPatientAssessment(), form.getMode().equals(FormMode.VIEW));
			populateCombos(dischargeDetails.getPatientAssessment());
			populateAuthoring(dischargeDetails.getPatientAssessment());
			populateCompletedHCPCustomControl(dischargeDetails.getPatientAssessment());
		}
		else
			initializeCustomControl();
 
	}
	private void populateCombos(PatientAssessmentVo patientAssessment)
	{
		if(patientAssessment == null)
			return;
		
		PatientAssessmentStatusReason status = patientAssessment.getStatus();
		boolean isEditMode = form.getMode().equals(FormMode.EDIT);
		if (isEditMode)
		{
			loadStatusCombo(true);
			if(status != null && status.equals(PatientAssessmentStatusReason.NOTCOMMENCED))
				status = PatientAssessmentStatusReason.INPROGRESS;
		}
		form.cmbStatus().setValue(status);
		cmbStatusValueChanged();
		form.cmbReason().setValue(patientAssessment.getStatusReason());
	}
	private void populateCompletedHCPCustomControl(PatientAssessmentVo patientAssessment)
	{
		if(patientAssessment == null)
			return;
		
		AuthoringInformationVo completedData = new AuthoringInformationVo();
		completedData.setAuthoringHcp(patientAssessment.getCompletedHCP());
		completedData.setAuthoringDateTime(patientAssessment.getCompletedDateTime());
		form.customControlCompleted().setValue(completedData);
	}
	private void populateAuthoring(PatientAssessmentVo patientAssessment)
	{
		AuthoringInformationVo voAuthoringInfo = null;
		if(patientAssessment != null)
			voAuthoringInfo = patientAssessment.getAuthoringInformation();
		
		if(voAuthoringInfo != null)
			form.customControlAuthoring().setValue(voAuthoringInfo);
		else
			form.customControlAuthoring().initializeComponent();
	}

	@Override
	protected void onFormModeChanged() 
	{
		if(form.getMode().equals(FormMode.VIEW))
			form.ccAssessment().setReadOnly(Boolean.TRUE);
		else
			form.ccAssessment().setReadOnly(Boolean.FALSE);
	}

	public void initialise() 
	{
		if ( form.getLocalContext().getbInitialised() == null)
		{
			form.setMode(FormMode.VIEW);
			loadStatusCombo(false);
			setInitialComponentsSettings();
			open();
			form.getLocalContext().setbInitialised(Boolean.TRUE);
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Assessment.AssessmentsForSpecialty) 
			&& result.equals(DialogResult.OK)
			&& form.getGlobalContext().Core.getSelectedUserAssessmentLiteIsNotNull())
		{
			form.getLocalContext().setChosenAssessment(domain.getUserAssessment(form.getGlobalContext().Core.getSelectedUserAssessmentLite()));
			loadAssessment();
		}
		if(formName.equals(form.getForms().Assessment.AssessmentsForSpecialty) 
			&& result.equals(DialogResult.CANCEL))
		{
			form.setMode(FormMode.VIEW);
			open();
			form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
			form.fireCustomControlValueChanged();
		}
	}

	public void setReadOnly() 
	{
		form.getLocalContext().setisReadonly(/*form.getGlobalContext().Clinical.geteDischargeCompleted()*/form.getGlobalContext().Clinical.geteDischargeClinicalComplete());
		manageReadOnly();
	}

	@Override
	protected void onCmbStatusValueChanged() throws PresentationLogicException {
		cmbStatusValueChanged();		
	}
	private void cmbStatusValueChanged()
	{
		form.cmbReason().clear();
		loadReasonCombo();	
		
		enableConfirmingHCPComponent();
	}

}