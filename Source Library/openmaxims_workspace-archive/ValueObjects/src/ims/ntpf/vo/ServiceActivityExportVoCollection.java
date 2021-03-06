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

package ims.ntpf.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.resource.ServiceActivityExport business object (ID: 1005100006).
 */
public class ServiceActivityExportVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ServiceActivityExportVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ServiceActivityExportVo> col = new ArrayList<ServiceActivityExportVo>();
	public String getBoClassName()
	{
		return "ims.core.resource.domain.objects.ServiceActivityExport";
	}
	public boolean add(ServiceActivityExportVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ServiceActivityExportVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(ServiceActivityExportVo instance)
	{
		return col.indexOf(instance);
	}
	public ServiceActivityExportVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ServiceActivityExportVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ServiceActivityExportVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ServiceActivityExportVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ServiceActivityExportVoCollection clone = new ServiceActivityExportVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ServiceActivityExportVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public ServiceActivityExportVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ServiceActivityExportVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ServiceActivityExportVoCollection sort(SortOrder order)
	{
		return sort(new ServiceActivityExportVoComparator(order));
	}
	public ServiceActivityExportVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ServiceActivityExportVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ServiceActivityExportVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.resource.vo.ServiceActivityExportRefVoCollection toRefVoCollection()
	{
		ims.core.resource.vo.ServiceActivityExportRefVoCollection result = new ims.core.resource.vo.ServiceActivityExportRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ServiceActivityExportVo[] toArray()
	{
		ServiceActivityExportVo[] arr = new ServiceActivityExportVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ServiceActivityExportVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ServiceActivityExportVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ServiceActivityExportVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ServiceActivityExportVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ServiceActivityExportVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ServiceActivityExportVo voObj1 = (ServiceActivityExportVo)obj1;
			ServiceActivityExportVo voObj2 = (ServiceActivityExportVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ntpf.vo.beans.ServiceActivityExportVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ntpf.vo.beans.ServiceActivityExportVoBean[] getBeanCollectionArray()
	{
		ims.ntpf.vo.beans.ServiceActivityExportVoBean[] result = new ims.ntpf.vo.beans.ServiceActivityExportVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ServiceActivityExportVo vo = ((ServiceActivityExportVo)col.get(i));
			result[i] = (ims.ntpf.vo.beans.ServiceActivityExportVoBean)vo.getBean();
		}
		return result;
	}
	public static ServiceActivityExportVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ServiceActivityExportVoCollection coll = new ServiceActivityExportVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ntpf.vo.beans.ServiceActivityExportVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ServiceActivityExportVoCollection buildFromBeanCollection(ims.ntpf.vo.beans.ServiceActivityExportVoBean[] beans)
	{
		ServiceActivityExportVoCollection coll = new ServiceActivityExportVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
