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

public class PDSResidentialStatus extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PDSResidentialStatus()
	{
		super();
	}
	public PDSResidentialStatus(int id)
	{
		super(id, "", true);
	}
	public PDSResidentialStatus(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PDSResidentialStatus(int id, String text, boolean active, PDSResidentialStatus parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PDSResidentialStatus(int id, String text, boolean active, PDSResidentialStatus parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PDSResidentialStatus(int id, String text, boolean active, PDSResidentialStatus parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PDSResidentialStatus buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PDSResidentialStatus(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PDSResidentialStatus)super.getParentInstance();
	}
	public PDSResidentialStatus getParent()
	{
		return (PDSResidentialStatus)super.getParentInstance();
	}
	public void setParent(PDSResidentialStatus parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PDSResidentialStatus[] typedChildren = new PDSResidentialStatus[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PDSResidentialStatus)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PDSResidentialStatus)
		{
			super.addChild((PDSResidentialStatus)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PDSResidentialStatus)
		{
			super.removeChild((PDSResidentialStatus)child);
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
		PDSResidentialStatusCollection result = new PDSResidentialStatusCollection();
		result.add(H);
		result.add(O);
		return result;
	}
	public static PDSResidentialStatus[] getNegativeInstances()
	{
		PDSResidentialStatus[] instances = new PDSResidentialStatus[2];
		instances[0] = H;
		instances[1] = O;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "H";
		negativeInstances[1] = "O";
		return negativeInstances;
	}
	public static PDSResidentialStatus getNegativeInstance(String name)
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
	public static PDSResidentialStatus getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PDSResidentialStatus[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1021348;
	public static final PDSResidentialStatus H = new PDSResidentialStatus(-3102, "H", true, null, null, Color.Default);
	public static final PDSResidentialStatus O = new PDSResidentialStatus(-3103, "Overseas", true, null, null, Color.Default);
}
