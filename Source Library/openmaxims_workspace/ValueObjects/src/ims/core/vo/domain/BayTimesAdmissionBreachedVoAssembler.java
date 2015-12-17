//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:25
 *
 */
package ims.core.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Gabriel Maxim
 */
public class BayTimesAdmissionBreachedVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.core.vo.BayTimesAdmissionBreachedVo copy(ims.core.vo.BayTimesAdmissionBreachedVo valueObjectDest, ims.core.vo.BayTimesAdmissionBreachedVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_BayTimesAdmissionBreach(valueObjectSrc.getID_BayTimesAdmissionBreach());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Ward
		valueObjectDest.setWard(valueObjectSrc.getWard());
		// Bay
		valueObjectDest.setBay(valueObjectSrc.getBay());
		// MemberOfStaff
		valueObjectDest.setMemberOfStaff(valueObjectSrc.getMemberOfStaff());
		// AdmissionDateTime
		valueObjectDest.setAdmissionDateTime(valueObjectSrc.getAdmissionDateTime());
		// ReasonForAdmissionOutOfOpeningHours
		valueObjectDest.setReasonForAdmissionOutOfOpeningHours(valueObjectSrc.getReasonForAdmissionOutOfOpeningHours());
		// ReasonForAdmissionOutOfOpeningHoursComment
		valueObjectDest.setReasonForAdmissionOutOfOpeningHoursComment(valueObjectSrc.getReasonForAdmissionOutOfOpeningHoursComment());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach objects.
	 */
	public static ims.core.vo.BayTimesAdmissionBreachedVoCollection createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(java.util.Set domainObjectSet)	
	{
		return createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach objects.
	 */
	public static ims.core.vo.BayTimesAdmissionBreachedVoCollection createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.core.vo.BayTimesAdmissionBreachedVoCollection voList = new ims.core.vo.BayTimesAdmissionBreachedVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject = (ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach) iterator.next();
			ims.core.vo.BayTimesAdmissionBreachedVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach objects.
	 */
	public static ims.core.vo.BayTimesAdmissionBreachedVoCollection createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(java.util.List domainObjectList) 
	{
		return createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach objects.
	 */
	public static ims.core.vo.BayTimesAdmissionBreachedVoCollection createBayTimesAdmissionBreachedVoCollectionFromBayTimesAdmissionBreach(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.core.vo.BayTimesAdmissionBreachedVoCollection voList = new ims.core.vo.BayTimesAdmissionBreachedVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject = (ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach) domainObjectList.get(i);
			ims.core.vo.BayTimesAdmissionBreachedVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractBayTimesAdmissionBreachSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVoCollection voCollection) 
	 {
	 	return extractBayTimesAdmissionBreachSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractBayTimesAdmissionBreachSet(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.BayTimesAdmissionBreachedVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject = BayTimesAdmissionBreachedVoAssembler.extractBayTimesAdmissionBreach(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
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
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractBayTimesAdmissionBreachList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVoCollection voCollection) 
	 {
	 	return extractBayTimesAdmissionBreachList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractBayTimesAdmissionBreachList(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.core.vo.BayTimesAdmissionBreachedVo vo = voCollection.get(i);
			ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject = BayTimesAdmissionBreachedVoAssembler.extractBayTimesAdmissionBreach(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach object.
	 * @param domainObject ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach
	 */
	 public static ims.core.vo.BayTimesAdmissionBreachedVo create(ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.core.vo.BayTimesAdmissionBreachedVo create(DomainObjectMap map, ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.core.vo.BayTimesAdmissionBreachedVo valueObject = (ims.core.vo.BayTimesAdmissionBreachedVo) map.getValueObject(domainObject, ims.core.vo.BayTimesAdmissionBreachedVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.core.vo.BayTimesAdmissionBreachedVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach
	 */
	 public static ims.core.vo.BayTimesAdmissionBreachedVo insert(ims.core.vo.BayTimesAdmissionBreachedVo valueObject, ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach
	 */
	 public static ims.core.vo.BayTimesAdmissionBreachedVo insert(DomainObjectMap map, ims.core.vo.BayTimesAdmissionBreachedVo valueObject, ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_BayTimesAdmissionBreach(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// Ward
		if (domainObject.getWard() != null)
		{
			if(domainObject.getWard() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getWard();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setWard(new ims.core.resource.place.vo.LocationRefVo(id, -1));				
			}
			else
			{
				valueObject.setWard(new ims.core.resource.place.vo.LocationRefVo(domainObject.getWard().getId(), domainObject.getWard().getVersion()));
			}
		}
		// Bay
		if (domainObject.getBay() != null)
		{
			if(domainObject.getBay() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getBay();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setBay(new ims.core.resource.place.vo.LocationRefVo(id, -1));				
			}
			else
			{
				valueObject.setBay(new ims.core.resource.place.vo.LocationRefVo(domainObject.getBay().getId(), domainObject.getBay().getVersion()));
			}
		}
		// MemberOfStaff
		valueObject.setMemberOfStaff(ims.core.vo.domain.MemberOfStaffLiteVoAssembler.create(map, domainObject.getMemberOfStaff()) );
		// AdmissionDateTime
		java.util.Date AdmissionDateTime = domainObject.getAdmissionDateTime();
		if ( null != AdmissionDateTime ) 
		{
			valueObject.setAdmissionDateTime(new ims.framework.utils.DateTime(AdmissionDateTime) );
		}
		// ReasonForAdmissionOutOfOpeningHours
		ims.domain.lookups.LookupInstance instance5 = domainObject.getReasonForAdmissionOutOfOpeningHours();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours voLookup5 = new ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.core.vo.lookups.ReasonForAdmissionOutOfOpeningHours(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setReasonForAdmissionOutOfOpeningHours(voLookup5);
		}
				// ReasonForAdmissionOutOfOpeningHoursComment
		valueObject.setReasonForAdmissionOutOfOpeningHoursComment(domainObject.getReasonForAdmissionOutOfOpeningHoursComment());
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach extractBayTimesAdmissionBreach(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVo valueObject) 
	{
		return 	extractBayTimesAdmissionBreach(domainFactory, valueObject, new HashMap());
	}

	public static ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach extractBayTimesAdmissionBreach(ims.domain.ILightweightDomainFactory domainFactory, ims.core.vo.BayTimesAdmissionBreachedVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_BayTimesAdmissionBreach();
		ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach)domMap.get(valueObject);
			}
			// ims.core.vo.BayTimesAdmissionBreachedVo ID_BayTimesAdmissionBreach field is unknown
			domainObject = new ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_BayTimesAdmissionBreach());
			if (domMap.get(key) != null)
			{
				return (ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach)domMap.get(key);
			}
			domainObject = (ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach) domainFactory.getDomainObject(ims.core.admin.pas.domain.objects.BayTimesAdmissionBreach.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_BayTimesAdmissionBreach());

		ims.core.resource.place.domain.objects.Location value1 = null;
		if ( null != valueObject.getWard() ) 
		{
			if (valueObject.getWard().getBoId() == null)
			{
				if (domMap.get(valueObject.getWard()) != null)
				{
					value1 = (ims.core.resource.place.domain.objects.Location)domMap.get(valueObject.getWard());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value1 = domainObject.getWard();	
			}
			else
			{
				value1 = (ims.core.resource.place.domain.objects.Location)domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Location.class, valueObject.getWard().getBoId());
			}
		}
		domainObject.setWard(value1);
		ims.core.resource.place.domain.objects.Location value2 = null;
		if ( null != valueObject.getBay() ) 
		{
			if (valueObject.getBay().getBoId() == null)
			{
				if (domMap.get(valueObject.getBay()) != null)
				{
					value2 = (ims.core.resource.place.domain.objects.Location)domMap.get(valueObject.getBay());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value2 = domainObject.getBay();	
			}
			else
			{
				value2 = (ims.core.resource.place.domain.objects.Location)domainFactory.getDomainObject(ims.core.resource.place.domain.objects.Location.class, valueObject.getBay().getBoId());
			}
		}
		domainObject.setBay(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.MemberOfStaff value3 = null;
		if ( null != valueObject.getMemberOfStaff() ) 
		{
			if (valueObject.getMemberOfStaff().getBoId() == null)
			{
				if (domMap.get(valueObject.getMemberOfStaff()) != null)
				{
					value3 = (ims.core.resource.people.domain.objects.MemberOfStaff)domMap.get(valueObject.getMemberOfStaff());
				}
			}
			else
			{
				value3 = (ims.core.resource.people.domain.objects.MemberOfStaff)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.MemberOfStaff.class, valueObject.getMemberOfStaff().getBoId());
			}
		}
		domainObject.setMemberOfStaff(value3);
		ims.framework.utils.DateTime dateTime4 = valueObject.getAdmissionDateTime();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setAdmissionDateTime(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getReasonForAdmissionOutOfOpeningHours() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getReasonForAdmissionOutOfOpeningHours().getID());
		}
		domainObject.setReasonForAdmissionOutOfOpeningHours(value5);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getReasonForAdmissionOutOfOpeningHoursComment() != null && valueObject.getReasonForAdmissionOutOfOpeningHoursComment().equals(""))
		{
			valueObject.setReasonForAdmissionOutOfOpeningHoursComment(null);
		}
		domainObject.setReasonForAdmissionOutOfOpeningHoursComment(valueObject.getReasonForAdmissionOutOfOpeningHoursComment());

		return domainObject;
	}

}