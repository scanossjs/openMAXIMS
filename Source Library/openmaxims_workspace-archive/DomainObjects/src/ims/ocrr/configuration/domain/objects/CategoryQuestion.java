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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.ocrr.configuration.domain.objects;

/**
 * 
 * @author Kevin O'Carroll
 * Generated.
 */


public class CategoryQuestion extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1061100011;
	private static final long serialVersionUID = 1061100011L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** OCRR Category */
	private ims.domain.lookups.LookupInstance oCRRCategory;
	/** isMandatory */
	private Boolean isMandatory;
	/** QuestionInformation */
	private ims.core.clinical.domain.objects.QuestionInformation questionInformation;
	/** Ask For Investigations */
	private Boolean askForInvestigations;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public CategoryQuestion (Integer id, int ver)
    {
    	super(id, ver);
    }
    public CategoryQuestion ()
    {
    	super();
    }
    public CategoryQuestion (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.ocrr.configuration.domain.objects.CategoryQuestion.class;
	}


	public ims.domain.lookups.LookupInstance getOCRRCategory() {
		return oCRRCategory;
	}
	public void setOCRRCategory(ims.domain.lookups.LookupInstance oCRRCategory) {
		this.oCRRCategory = oCRRCategory;
	}

	public Boolean isIsMandatory() {
		return isMandatory;
	}
	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public ims.core.clinical.domain.objects.QuestionInformation getQuestionInformation() {
		return questionInformation;
	}
	public void setQuestionInformation(ims.core.clinical.domain.objects.QuestionInformation questionInformation) {
		this.questionInformation = questionInformation;
	}

	public Boolean isAskForInvestigations() {
		return askForInvestigations;
	}
	public void setAskForInvestigations(Boolean askForInvestigations) {
		this.askForInvestigations = askForInvestigations;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Configuration".equals("Configuration") )
			return true;
		else
			return false;
	}
	// method generated based on 'ocrr_categoryquest_unq1' unique index.
	public static boolean recordExistForOCRRCategoryAndQuestionInformation(ims.domain.ILightweightDomainFactory factory,
		 ims.domain.lookups.LookupInstance oCRRCategory
	,
	 ims.core.clinical.domain.objects.QuestionInformation questionInformation
	)	
	{
		return recordExistForOCRRCategoryAndQuestionInformation(factory, oCRRCategory, questionInformation, null);
	}	

	// method generated based on 'ocrr_categoryquest_unq1' unique index.
	public static boolean recordExistForOCRRCategoryAndQuestionInformation(ims.domain.ILightweightDomainFactory factory,
		 ims.domain.lookups.LookupInstance oCRRCategory
	,
	 ims.core.clinical.domain.objects.QuestionInformation questionInformation
	, Integer recordId)	
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		
		hql.append("from CategoryQuestion c where ");
		hql.append(" c.oCRRCategory = :oCRRCategory ");
		names[0] = "oCRRCategory";
		values[0] = oCRRCategory;		
		hql.append(" and "); 
		hql.append(" c.questionInformation = :questionInformation ");
		names[1] = "questionInformation";
		values[1] = questionInformation;		
		if(recordId != null)
		{
			hql.append(" and c.id <> " + recordId);
		}
		
		return factory.count(hql.toString(), names, values) > 0;				
	}	

	// method generated based on 'ocrr_categoryquest_unq1' unique index.
	public static CategoryQuestion getRecordByOCRRCategoryAndQuestionInformation(ims.domain.ILightweightDomainFactory factory,
	 ims.domain.lookups.LookupInstance oCRRCategory
	,
	 ims.core.clinical.domain.objects.QuestionInformation questionInformation
	)
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		hql.append("from CategoryQuestion c where ");
		hql.append(" c.oCRRCategory = :oCRRCategory ");
		names[0] = "oCRRCategory";
		values[0] = oCRRCategory;		
		hql.append(" and "); 
		hql.append(" c.questionInformation = :questionInformation ");
		names[1] = "questionInformation";
		values[1] = questionInformation;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (CategoryQuestion)l.get(0);
	}

	public static CategoryQuestion getCategoryQuestionFromocrr_categoryquest_unq1(ims.domain.ILightweightDomainFactory factory,
	 ims.domain.lookups.LookupInstance oCRRCategory
	,
	 ims.core.clinical.domain.objects.QuestionInformation questionInformation
	)
	{
		String[] names = new String[2];
		Object[] values = new Object[2];
		StringBuffer hql = new StringBuffer();
		hql.append("from CategoryQuestion c where ");
		hql.append(" c.oCRRCategory = :oCRRCategory ");
		names[0] = "oCRRCategory";
		values[0] = oCRRCategory;		
		hql.append(" and "); 
		hql.append(" c.questionInformation = :questionInformation ");
		names[1] = "questionInformation";
		values[1] = questionInformation;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (CategoryQuestion)l.get(0);
	}


	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*oCRRCategory* :");
		if (oCRRCategory != null)
			auditStr.append(oCRRCategory.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*isMandatory* :");
		auditStr.append(isMandatory);
	    auditStr.append("; ");
		auditStr.append("\r\n*questionInformation* :");
		if (questionInformation != null)
		{
			auditStr.append(toShortClassName(questionInformation));
				
		    auditStr.append(questionInformation.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*askForInvestigations* :");
		auditStr.append(askForInvestigations);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "CategoryQuestion";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getOCRRCategory() != null)
		{
			sb.append("<oCRRCategory>");
			sb.append(this.getOCRRCategory().toXMLString()); 
			sb.append("</oCRRCategory>");		
		}
		if (this.isIsMandatory() != null)
		{
			sb.append("<isMandatory>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isIsMandatory().toString()));
			sb.append("</isMandatory>");		
		}
		if (this.getQuestionInformation() != null)
		{
			sb.append("<questionInformation>");
			sb.append(this.getQuestionInformation().toXMLString(domMap)); 	
			sb.append("</questionInformation>");		
		}
		if (this.isAskForInvestigations() != null)
		{
			sb.append("<askForInvestigations>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isAskForInvestigations().toString()));
			sb.append("</askForInvestigations>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			CategoryQuestion domainObject = getCategoryQuestionfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			CategoryQuestion domainObject = getCategoryQuestionfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static CategoryQuestion getCategoryQuestionfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getCategoryQuestionfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static CategoryQuestion getCategoryQuestionfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!CategoryQuestion.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!CategoryQuestion.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the CategoryQuestion class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (CategoryQuestion)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(CategoryQuestion.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		CategoryQuestion ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (CategoryQuestion)factory.getImportedDomainObject(CategoryQuestion.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new CategoryQuestion();
		}
		String keyClassName = "CategoryQuestion";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (CategoryQuestion)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, CategoryQuestion obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("oCRRCategory");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setOCRRCategory(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("isMandatory");
		if(fldEl != null)
		{	
    		obj.setIsMandatory(new Boolean(fldEl.getTextTrim()));	
		}
		fldEl = el.element("questionInformation");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setQuestionInformation(ims.core.clinical.domain.objects.QuestionInformation.getQuestionInformationfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("askForInvestigations");
		if(fldEl != null)
		{	
    		obj.setAskForInvestigations(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String OCRRCategory = "oCRRCategory";
		public static final String IsMandatory = "isMandatory";
		public static final String QuestionInformation = "questionInformation";
		public static final String AskForInvestigations = "askForInvestigations";
	}
}

