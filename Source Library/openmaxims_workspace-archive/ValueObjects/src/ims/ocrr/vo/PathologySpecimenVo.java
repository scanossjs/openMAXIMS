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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.OrderSpecimen business object (ID: 1070100010).
 */
public class PathologySpecimenVo extends ims.ocrr.vo.PathologySpecimenLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologySpecimenVo()
	{
	}
	public PathologySpecimenVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologySpecimenVo(ims.ocrr.vo.beans.PathologySpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.coltimefillersupplied = bean.getColTimeFillerSupplied();
		this.colldatetimeplacer = bean.getCollDateTimePlacer() == null ? null : bean.getCollDateTimePlacer().buildDateTime();
		this.receiveddatetime = bean.getReceivedDateTime() == null ? null : bean.getReceivedDateTime().buildDateTime();
		this.receivedtimesupplied = bean.getReceivedTimeSupplied();
		this.investigations = ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.order = bean.getOrder() == null ? null : bean.getOrder().buildVo();
		this.fillerordnum = bean.getFillerOrdNum();
		this.discipline = bean.getDiscipline() == null ? null : bean.getDiscipline().buildVo();
		this.ispatientcollect = bean.getIsPatientCollect();
		this.isawaitingcollection = bean.getIsAwaitingCollection();
		this.colldatetimefiller = bean.getCollDateTimeFiller() == null ? null : bean.getCollDateTimeFiller().buildDateTime();
		this.requestedtype = bean.getRequestedType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getRequestedType());
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologySpecimenVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.specimensource = bean.getSpecimenSource() == null ? null : ims.ocrr.vo.lookups.SpecimenType.buildLookup(bean.getSpecimenSource());
		this.sitecd = bean.getSiteCd() == null ? null : ims.ocrr.vo.lookups.SpecimenSite.buildLookup(bean.getSiteCd());
		this.resultconclusioncomments = ims.ocrr.vo.ResultCommentsLiteVoCollection.buildFromBeanCollection(bean.getResultConclusionComments());
		this.coltimefillersupplied = bean.getColTimeFillerSupplied();
		this.colldatetimeplacer = bean.getCollDateTimePlacer() == null ? null : bean.getCollDateTimePlacer().buildDateTime();
		this.receiveddatetime = bean.getReceivedDateTime() == null ? null : bean.getReceivedDateTime().buildDateTime();
		this.receivedtimesupplied = bean.getReceivedTimeSupplied();
		this.investigations = ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection.buildFromBeanCollection(bean.getInvestigations());
		this.order = bean.getOrder() == null ? null : bean.getOrder().buildVo(map);
		this.fillerordnum = bean.getFillerOrdNum();
		this.discipline = bean.getDiscipline() == null ? null : bean.getDiscipline().buildVo(map);
		this.ispatientcollect = bean.getIsPatientCollect();
		this.isawaitingcollection = bean.getIsAwaitingCollection();
		this.colldatetimefiller = bean.getCollDateTimeFiller() == null ? null : bean.getCollDateTimeFiller().buildDateTime();
		this.requestedtype = bean.getRequestedType() == null ? null : ims.ocrr.vo.lookups.SpecimenCollectionType.buildLookup(bean.getRequestedType());
		this.placerordnum = bean.getPlacerOrdNum();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologySpecimenVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologySpecimenVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologySpecimenVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("COLLDATETIMEPLACER"))
			return getCollDateTimePlacer();
		if(fieldName.equals("RECEIVEDDATETIME"))
			return getReceivedDateTime();
		if(fieldName.equals("RECEIVEDTIMESUPPLIED"))
			return getReceivedTimeSupplied();
		if(fieldName.equals("INVESTIGATIONS"))
			return getInvestigations();
		if(fieldName.equals("ORDER"))
			return getOrder();
		if(fieldName.equals("FILLERORDNUM"))
			return getFillerOrdNum();
		if(fieldName.equals("DISCIPLINE"))
			return getDiscipline();
		if(fieldName.equals("ISPATIENTCOLLECT"))
			return getIsPatientCollect();
		if(fieldName.equals("ISAWAITINGCOLLECTION"))
			return getIsAwaitingCollection();
		if(fieldName.equals("COLLDATETIMEFILLER"))
			return getCollDateTimeFiller();
		if(fieldName.equals("REQUESTEDTYPE"))
			return getRequestedType();
		if(fieldName.equals("PLACERORDNUM"))
			return getPlacerOrdNum();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCollDateTimePlacerIsNotNull()
	{
		return this.colldatetimeplacer != null;
	}
	public ims.framework.utils.DateTime getCollDateTimePlacer()
	{
		return this.colldatetimeplacer;
	}
	public void setCollDateTimePlacer(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.colldatetimeplacer = value;
	}
	public boolean getReceivedDateTimeIsNotNull()
	{
		return this.receiveddatetime != null;
	}
	public ims.framework.utils.DateTime getReceivedDateTime()
	{
		return this.receiveddatetime;
	}
	public void setReceivedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.receiveddatetime = value;
	}
	public boolean getReceivedTimeSuppliedIsNotNull()
	{
		return this.receivedtimesupplied != null;
	}
	public Boolean getReceivedTimeSupplied()
	{
		return this.receivedtimesupplied;
	}
	public void setReceivedTimeSupplied(Boolean value)
	{
		this.isValidated = false;
		this.receivedtimesupplied = value;
	}
	public boolean getInvestigationsIsNotNull()
	{
		return this.investigations != null;
	}
	public ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection value)
	{
		this.isValidated = false;
		this.investigations = value;
	}
	public boolean getOrderIsNotNull()
	{
		return this.order != null;
	}
	public ims.ocrr.vo.NewResultOcsOrderVo getOrder()
	{
		return this.order;
	}
	public void setOrder(ims.ocrr.vo.NewResultOcsOrderVo value)
	{
		this.isValidated = false;
		this.order = value;
	}
	public boolean getFillerOrdNumIsNotNull()
	{
		return this.fillerordnum != null;
	}
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public static int getFillerOrdNumMaxLength()
	{
		return 20;
	}
	public void setFillerOrdNum(String value)
	{
		this.isValidated = false;
		this.fillerordnum = value;
	}
	public boolean getDisciplineIsNotNull()
	{
		return this.discipline != null;
	}
	public ims.core.vo.ServiceLiteVo getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.discipline = value;
	}
	public boolean getIsPatientCollectIsNotNull()
	{
		return this.ispatientcollect != null;
	}
	public Boolean getIsPatientCollect()
	{
		return this.ispatientcollect;
	}
	public void setIsPatientCollect(Boolean value)
	{
		this.isValidated = false;
		this.ispatientcollect = value;
	}
	public boolean getIsAwaitingCollectionIsNotNull()
	{
		return this.isawaitingcollection != null;
	}
	public Boolean getIsAwaitingCollection()
	{
		return this.isawaitingcollection;
	}
	public void setIsAwaitingCollection(Boolean value)
	{
		this.isValidated = false;
		this.isawaitingcollection = value;
	}
	public boolean getCollDateTimeFillerIsNotNull()
	{
		return this.colldatetimefiller != null;
	}
	public ims.framework.utils.DateTime getCollDateTimeFiller()
	{
		return this.colldatetimefiller;
	}
	public void setCollDateTimeFiller(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.colldatetimefiller = value;
	}
	public boolean getRequestedTypeIsNotNull()
	{
		return this.requestedtype != null;
	}
	public ims.ocrr.vo.lookups.SpecimenCollectionType getRequestedType()
	{
		return this.requestedtype;
	}
	public void setRequestedType(ims.ocrr.vo.lookups.SpecimenCollectionType value)
	{
		this.isValidated = false;
		this.requestedtype = value;
	}
	public boolean getPlacerOrdNumIsNotNull()
	{
		return this.placerordnum != null;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public static int getPlacerOrdNumMaxLength()
	{
		return 20;
	}
	public void setPlacerOrdNum(String value)
	{
		this.isValidated = false;
		this.placerordnum = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.investigations != null)
		{
			if(!this.investigations.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.order != null)
		{
			if(!this.order.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.discipline != null)
		{
			if(!this.discipline.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.specimensource == null)
			listOfErrors.add("SpecimenSource is mandatory");
		if(this.investigations != null)
		{
			String[] listOfOtherErrors = this.investigations.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.order != null)
		{
			String[] listOfOtherErrors = this.order.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.fillerordnum != null)
			if(this.fillerordnum.length() > 20)
				listOfErrors.add("The length of the field [fillerordnum] in the value object [ims.ocrr.vo.PathologySpecimenVo] is too big. It should be less or equal to 20");
		if(this.discipline == null)
			listOfErrors.add("Discipline is mandatory");
		if(this.discipline != null)
		{
			String[] listOfOtherErrors = this.discipline.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ispatientcollect == null)
			listOfErrors.add("IsPatientCollect is mandatory");
		if(this.isawaitingcollection == null)
			listOfErrors.add("IsAwaitingCollection is mandatory");
		if(this.placerordnum == null || this.placerordnum.length() == 0)
			listOfErrors.add("PlacerOrdNum is mandatory");
		else if(this.placerordnum.length() > 20)
			listOfErrors.add("The length of the field [placerordnum] in the value object [ims.ocrr.vo.PathologySpecimenVo] is too big. It should be less or equal to 20");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PathologySpecimenVo clone = new PathologySpecimenVo(this.id, this.version);
		
		if(this.specimensource == null)
			clone.specimensource = null;
		else
			clone.specimensource = (ims.ocrr.vo.lookups.SpecimenType)this.specimensource.clone();
		if(this.sitecd == null)
			clone.sitecd = null;
		else
			clone.sitecd = (ims.ocrr.vo.lookups.SpecimenSite)this.sitecd.clone();
		if(this.resultconclusioncomments == null)
			clone.resultconclusioncomments = null;
		else
			clone.resultconclusioncomments = (ims.ocrr.vo.ResultCommentsLiteVoCollection)this.resultconclusioncomments.clone();
		clone.coltimefillersupplied = this.coltimefillersupplied;
		if(this.colldatetimeplacer == null)
			clone.colldatetimeplacer = null;
		else
			clone.colldatetimeplacer = (ims.framework.utils.DateTime)this.colldatetimeplacer.clone();
		if(this.receiveddatetime == null)
			clone.receiveddatetime = null;
		else
			clone.receiveddatetime = (ims.framework.utils.DateTime)this.receiveddatetime.clone();
		clone.receivedtimesupplied = this.receivedtimesupplied;
		if(this.investigations == null)
			clone.investigations = null;
		else
			clone.investigations = (ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection)this.investigations.clone();
		if(this.order == null)
			clone.order = null;
		else
			clone.order = (ims.ocrr.vo.NewResultOcsOrderVo)this.order.clone();
		clone.fillerordnum = this.fillerordnum;
		if(this.discipline == null)
			clone.discipline = null;
		else
			clone.discipline = (ims.core.vo.ServiceLiteVo)this.discipline.clone();
		clone.ispatientcollect = this.ispatientcollect;
		clone.isawaitingcollection = this.isawaitingcollection;
		if(this.colldatetimefiller == null)
			clone.colldatetimefiller = null;
		else
			clone.colldatetimefiller = (ims.framework.utils.DateTime)this.colldatetimefiller.clone();
		if(this.requestedtype == null)
			clone.requestedtype = null;
		else
			clone.requestedtype = (ims.ocrr.vo.lookups.SpecimenCollectionType)this.requestedtype.clone();
		clone.placerordnum = this.placerordnum;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PathologySpecimenVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologySpecimenVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathologySpecimenVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathologySpecimenVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.colldatetimeplacer != null)
			count++;
		if(this.receiveddatetime != null)
			count++;
		if(this.receivedtimesupplied != null)
			count++;
		if(this.investigations != null)
			count++;
		if(this.order != null)
			count++;
		if(this.fillerordnum != null)
			count++;
		if(this.discipline != null)
			count++;
		if(this.ispatientcollect != null)
			count++;
		if(this.isawaitingcollection != null)
			count++;
		if(this.colldatetimefiller != null)
			count++;
		if(this.requestedtype != null)
			count++;
		if(this.placerordnum != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 12;
	}
	protected ims.framework.utils.DateTime colldatetimeplacer;
	protected ims.framework.utils.DateTime receiveddatetime;
	protected Boolean receivedtimesupplied;
	protected ims.ocrr.vo.PathologySpecimenOrderInvestigationVoCollection investigations;
	protected ims.ocrr.vo.NewResultOcsOrderVo order;
	protected String fillerordnum;
	protected ims.core.vo.ServiceLiteVo discipline;
	protected Boolean ispatientcollect;
	protected Boolean isawaitingcollection;
	protected ims.framework.utils.DateTime colldatetimefiller;
	protected ims.ocrr.vo.lookups.SpecimenCollectionType requestedtype;
	protected String placerordnum;
	private boolean isValidated = false;
	private boolean isBusy = false;
}