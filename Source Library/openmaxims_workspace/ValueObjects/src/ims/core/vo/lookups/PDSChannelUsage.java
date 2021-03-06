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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PDSChannelUsage extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PDSChannelUsage()
	{
		super();
	}
	public PDSChannelUsage(int id)
	{
		super(id, "", true);
	}
	public PDSChannelUsage(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PDSChannelUsage(int id, String text, boolean active, PDSChannelUsage parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PDSChannelUsage(int id, String text, boolean active, PDSChannelUsage parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PDSChannelUsage(int id, String text, boolean active, PDSChannelUsage parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PDSChannelUsage buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PDSChannelUsage(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PDSChannelUsage)super.getParentInstance();
	}
	public PDSChannelUsage getParent()
	{
		return (PDSChannelUsage)super.getParentInstance();
	}
	public void setParent(PDSChannelUsage parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PDSChannelUsage[] typedChildren = new PDSChannelUsage[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PDSChannelUsage)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PDSChannelUsage)
		{
			super.addChild((PDSChannelUsage)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PDSChannelUsage)
		{
			super.removeChild((PDSChannelUsage)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		PDSChannelUsageCollection result = new PDSChannelUsageCollection();
		result.add(H);
		result.add(HP);
		result.add(HV);
		result.add(MC);
		result.add(PG);
		result.add(WP);
		result.add(AS);
		result.add(EC);
		return result;
	}
	public static PDSChannelUsage[] getNegativeInstances()
	{
		PDSChannelUsage[] instances = new PDSChannelUsage[8];
		instances[0] = H;
		instances[1] = HP;
		instances[2] = HV;
		instances[3] = MC;
		instances[4] = PG;
		instances[5] = WP;
		instances[6] = AS;
		instances[7] = EC;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[8];
		negativeInstances[0] = "H";
		negativeInstances[1] = "HP";
		negativeInstances[2] = "HV";
		negativeInstances[3] = "MC";
		negativeInstances[4] = "PG";
		negativeInstances[5] = "WP";
		negativeInstances[6] = "AS";
		negativeInstances[7] = "EC";
		return negativeInstances;
	}
	public static PDSChannelUsage getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static PDSChannelUsage getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PDSChannelUsage[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021374;
	public static final PDSChannelUsage H = new PDSChannelUsage(-3182, "Home Contact", true, null, null, Color.Default);
	public static final PDSChannelUsage HP = new PDSChannelUsage(-3183, "Home", true, null, null, Color.Default);
	public static final PDSChannelUsage HV = new PDSChannelUsage(-3184, "Holiday Home", true, null, null, Color.Default);
	public static final PDSChannelUsage MC = new PDSChannelUsage(-3185, "Mobile", true, null, null, Color.Default);
	public static final PDSChannelUsage PG = new PDSChannelUsage(-3186, "Pager", true, null, null, Color.Default);
	public static final PDSChannelUsage WP = new PDSChannelUsage(-3187, "Office Address", true, null, null, Color.Default);
	public static final PDSChannelUsage AS = new PDSChannelUsage(-3188, "Answering Machine", true, null, null, Color.Default);
	public static final PDSChannelUsage EC = new PDSChannelUsage(-3189, "Emergency Contact", true, null, null, Color.Default);
}
