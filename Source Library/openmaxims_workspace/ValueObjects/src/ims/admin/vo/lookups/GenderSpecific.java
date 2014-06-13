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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class GenderSpecific extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public GenderSpecific()
	{
		super();
	}
	public GenderSpecific(int id)
	{
		super(id, "", true);
	}
	public GenderSpecific(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public GenderSpecific(int id, String text, boolean active, GenderSpecific parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public GenderSpecific(int id, String text, boolean active, GenderSpecific parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public GenderSpecific(int id, String text, boolean active, GenderSpecific parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static GenderSpecific buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new GenderSpecific(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (GenderSpecific)super.getParentInstance();
	}
	public GenderSpecific getParent()
	{
		return (GenderSpecific)super.getParentInstance();
	}
	public void setParent(GenderSpecific parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		GenderSpecific[] typedChildren = new GenderSpecific[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (GenderSpecific)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof GenderSpecific)
		{
			super.addChild((GenderSpecific)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof GenderSpecific)
		{
			super.removeChild((GenderSpecific)child);
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
		GenderSpecificCollection result = new GenderSpecificCollection();
		result.add(MALE);
		result.add(FEMALE);
		result.add(NOTAPPLICABLE);
		return result;
	}
	public static GenderSpecific[] getNegativeInstances()
	{
		GenderSpecific[] instances = new GenderSpecific[3];
		instances[0] = MALE;
		instances[1] = FEMALE;
		instances[2] = NOTAPPLICABLE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "MALE";
		negativeInstances[1] = "FEMALE";
		negativeInstances[2] = "NOTAPPLICABLE";
		return negativeInstances;
	}
	public static GenderSpecific getNegativeInstance(String name)
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
	public static GenderSpecific getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		GenderSpecific[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1031002;
	public static final GenderSpecific MALE = new GenderSpecific(-388, "Male", true, null, null, Color.Default);
	public static final GenderSpecific FEMALE = new GenderSpecific(-389, "Female", true, null, null, Color.Default);
	public static final GenderSpecific NOTAPPLICABLE = new GenderSpecific(-390, "Not Applicable", true, null, null, Color.Default);
}