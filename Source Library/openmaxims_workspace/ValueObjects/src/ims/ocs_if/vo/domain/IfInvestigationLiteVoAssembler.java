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
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.ocs_if.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author John MacEnri
 */
public class IfInvestigationLiteVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.ocs_if.vo.IfInvestigationLiteVo copy(ims.ocs_if.vo.IfInvestigationLiteVo valueObjectDest, ims.ocs_if.vo.IfInvestigationLiteVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Investigation(valueObjectSrc.getID_Investigation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// ProviderInvCode
		valueObjectDest.setProviderInvCode(valueObjectSrc.getProviderInvCode());
		// ActiveStatus
		valueObjectDest.setActiveStatus(valueObjectSrc.getActiveStatus());
		// SeparateOrder
		valueObjectDest.setSeparateOrder(valueObjectSrc.getSeparateOrder());
		// InvestigationIndex
		valueObjectDest.setInvestigationIndex(valueObjectSrc.getInvestigationIndex());
		// PathInvDetails
		valueObjectDest.setPathInvDetails(valueObjectSrc.getPathInvDetails());
		// Type
		valueObjectDest.setType(valueObjectSrc.getType());
		// EventType
		valueObjectDest.setEventType(valueObjectSrc.getEventType());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createIfInvestigationLiteVoCollectionFromInvestigation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.ocrr.configuration.domain.objects.Investigation objects.
	 */
	public static ims.ocs_if.vo.IfInvestigationLiteVoCollection createIfInvestigationLiteVoCollectionFromInvestigation(java.util.Set domainObjectSet)	
	{
		return createIfInvestigationLiteVoCollectionFromInvestigation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.ocrr.configuration.domain.objects.Investigation objects.
	 */
	public static ims.ocs_if.vo.IfInvestigationLiteVoCollection createIfInvestigationLiteVoCollectionFromInvestigation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.ocs_if.vo.IfInvestigationLiteVoCollection voList = new ims.ocs_if.vo.IfInvestigationLiteVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.ocrr.configuration.domain.objects.Investigation domainObject = (ims.ocrr.configuration.domain.objects.Investigation) iterator.next();
			ims.ocs_if.vo.IfInvestigationLiteVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.ocrr.configuration.domain.objects.Investigation objects.
	 */
	public static ims.ocs_if.vo.IfInvestigationLiteVoCollection createIfInvestigationLiteVoCollectionFromInvestigation(java.util.List domainObjectList) 
	{
		return createIfInvestigationLiteVoCollectionFromInvestigation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.ocrr.configuration.domain.objects.Investigation objects.
	 */
	public static ims.ocs_if.vo.IfInvestigationLiteVoCollection createIfInvestigationLiteVoCollectionFromInvestigation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.ocs_if.vo.IfInvestigationLiteVoCollection voList = new ims.ocs_if.vo.IfInvestigationLiteVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.ocrr.configuration.domain.objects.Investigation domainObject = (ims.ocrr.configuration.domain.objects.Investigation) domainObjectList.get(i);
			ims.ocs_if.vo.IfInvestigationLiteVo vo = create(map, domainObject);

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
	 * Create the ims.ocrr.configuration.domain.objects.Investigation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVoCollection voCollection) 
	 {
	 	return extractInvestigationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.ocs_if.vo.IfInvestigationLiteVo vo = voCollection.get(i);
			ims.ocrr.configuration.domain.objects.Investigation domainObject = IfInvestigationLiteVoAssembler.extractInvestigation(domainFactory, vo, domMap);

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
	 * Create the ims.ocrr.configuration.domain.objects.Investigation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVoCollection voCollection) 
	 {
	 	return extractInvestigationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.ocs_if.vo.IfInvestigationLiteVo vo = voCollection.get(i);
			ims.ocrr.configuration.domain.objects.Investigation domainObject = IfInvestigationLiteVoAssembler.extractInvestigation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.ocrr.configuration.domain.objects.Investigation object.
	 * @param domainObject ims.ocrr.configuration.domain.objects.Investigation
	 */
	 public static ims.ocs_if.vo.IfInvestigationLiteVo create(ims.ocrr.configuration.domain.objects.Investigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.ocrr.configuration.domain.objects.Investigation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.ocs_if.vo.IfInvestigationLiteVo create(DomainObjectMap map, ims.ocrr.configuration.domain.objects.Investigation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.ocs_if.vo.IfInvestigationLiteVo valueObject = (ims.ocs_if.vo.IfInvestigationLiteVo) map.getValueObject(domainObject, ims.ocs_if.vo.IfInvestigationLiteVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.ocs_if.vo.IfInvestigationLiteVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.ocrr.configuration.domain.objects.Investigation
	 */
	 public static ims.ocs_if.vo.IfInvestigationLiteVo insert(ims.ocs_if.vo.IfInvestigationLiteVo valueObject, ims.ocrr.configuration.domain.objects.Investigation domainObject) 
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
	 * @param domainObject ims.ocrr.configuration.domain.objects.Investigation
	 */
	 public static ims.ocs_if.vo.IfInvestigationLiteVo insert(DomainObjectMap map, ims.ocs_if.vo.IfInvestigationLiteVo valueObject, ims.ocrr.configuration.domain.objects.Investigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Investigation(domainObject.getId());
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
			
		// ProviderInvCode
		valueObject.setProviderInvCode(domainObject.getProviderInvCode());
		// ActiveStatus
		ims.domain.lookups.LookupInstance instance2 = domainObject.getActiveStatus();
		if ( null != instance2 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance2.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance2.getImage().getImageId(), instance2.getImage().getImagePath());
			}
			color = instance2.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup2 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup2 = voLookup2;
			ims.domain.lookups.LookupInstance parent2 = instance2.getParent();
			while (parent2 != null)
			{
				if (parent2.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent2.getImage().getImageId(), parent2.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent2.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup2.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setActiveStatus(voLookup2);
		}
				// SeparateOrder
		valueObject.setSeparateOrder( domainObject.isSeparateOrder() );
		// InvestigationIndex
		valueObject.setInvestigationIndex(ims.ocs_if.vo.domain.IfInvIdxLiteVoAssembler.create(map, domainObject.getInvestigationIndex()) );
		// PathInvDetails
		valueObject.setPathInvDetails(ims.ocrr.vo.domain.PathInvDetailsVoAssembler.create(map, domainObject.getPathInvDetails()) );
		// Type
		ims.domain.lookups.LookupInstance instance6 = domainObject.getType();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.InvType voLookup6 = new ims.ocrr.vo.lookups.InvType(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.ocrr.vo.lookups.InvType parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.ocrr.vo.lookups.InvType(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setType(voLookup6);
		}
				// EventType
		ims.domain.lookups.LookupInstance instance7 = domainObject.getEventType();
		if ( null != instance7 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance7.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance7.getImage().getImageId(), instance7.getImage().getImagePath());
			}
			color = instance7.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.InvEventType voLookup7 = new ims.ocrr.vo.lookups.InvEventType(instance7.getId(),instance7.getText(), instance7.isActive(), null, img, color);
			ims.ocrr.vo.lookups.InvEventType parentVoLookup7 = voLookup7;
			ims.domain.lookups.LookupInstance parent7 = instance7.getParent();
			while (parent7 != null)
			{
				if (parent7.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent7.getImage().getImageId(), parent7.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent7.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup7.setParent(new ims.ocrr.vo.lookups.InvEventType(parent7.getId(),parent7.getText(), parent7.isActive(), null, img, color));
				parentVoLookup7 = parentVoLookup7.getParent();
								parent7 = parent7.getParent();
			}			
			valueObject.setEventType(voLookup7);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.ocrr.configuration.domain.objects.Investigation extractInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVo valueObject) 
	{
		return 	extractInvestigation(domainFactory, valueObject, new HashMap());
	}

	public static ims.ocrr.configuration.domain.objects.Investigation extractInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocs_if.vo.IfInvestigationLiteVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Investigation();
		ims.ocrr.configuration.domain.objects.Investigation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.ocrr.configuration.domain.objects.Investigation)domMap.get(valueObject);
			}
			// ims.ocs_if.vo.IfInvestigationLiteVo ID_Investigation field is unknown
			domainObject = new ims.ocrr.configuration.domain.objects.Investigation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Investigation());
			if (domMap.get(key) != null)
			{
				return (ims.ocrr.configuration.domain.objects.Investigation)domMap.get(key);
			}
			domainObject = (ims.ocrr.configuration.domain.objects.Investigation) domainFactory.getDomainObject(ims.ocrr.configuration.domain.objects.Investigation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Investigation());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getProviderInvCode() != null && valueObject.getProviderInvCode().equals(""))
		{
			valueObject.setProviderInvCode(null);
		}
		domainObject.setProviderInvCode(valueObject.getProviderInvCode());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getActiveStatus() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getActiveStatus().getID());
		}
		domainObject.setActiveStatus(value2);
		domainObject.setSeparateOrder(valueObject.getSeparateOrder());
		domainObject.setInvestigationIndex(ims.ocs_if.vo.domain.IfInvIdxLiteVoAssembler.extractInvestigationIndex(domainFactory, valueObject.getInvestigationIndex(), domMap));
		domainObject.setPathInvDetails(ims.ocrr.vo.domain.PathInvDetailsVoAssembler.extractPathInvDetails(domainFactory, valueObject.getPathInvDetails(), domMap));
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getType() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getType().getID());
		}
		domainObject.setType(value6);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value7 = null;
		if ( null != valueObject.getEventType() ) 
		{
			value7 =
				domainFactory.getLookupInstance(valueObject.getEventType().getID());
		}
		domainObject.setEventType(value7);

		return domainObject;
	}

}
