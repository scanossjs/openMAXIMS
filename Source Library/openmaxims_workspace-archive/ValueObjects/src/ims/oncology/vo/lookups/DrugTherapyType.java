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

package ims.oncology.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class DrugTherapyType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DrugTherapyType()
	{
		super();
	}
	public DrugTherapyType(int id)
	{
		super(id, "", true);
	}
	public DrugTherapyType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DrugTherapyType(int id, String text, boolean active, DrugTherapyType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DrugTherapyType(int id, String text, boolean active, DrugTherapyType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DrugTherapyType(int id, String text, boolean active, DrugTherapyType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DrugTherapyType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DrugTherapyType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DrugTherapyType)super.getParentInstance();
	}
	public DrugTherapyType getParent()
	{
		return (DrugTherapyType)super.getParentInstance();
	}
	public void setParent(DrugTherapyType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DrugTherapyType[] typedChildren = new DrugTherapyType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DrugTherapyType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DrugTherapyType)
		{
			super.addChild((DrugTherapyType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DrugTherapyType)
		{
			super.removeChild((DrugTherapyType)child);
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
		DrugTherapyTypeCollection result = new DrugTherapyTypeCollection();
		result.add(HORMONE_THERAPY);
		result.add(HIGHCOSTDRUG);
		result.add(BIPHOSPHONATES);
		result.add(IMMUNOTHERAPY);
		result.add(OTHER);
		result.add(TKI);
		result.add(CHEMOTHERAPY1STLINE);
		result.add(CHEMOTHERAPY2NDLINE);
		result.add(CHEMOTHERAPY3RDLINE);
		result.add(CHEMOTHERAPY4THLINE);
		result.add(CHEMOTHERAPY5THLINE);
		result.add(CHEMOTHERAPY6THLINE);
		result.add(CHEMOTHERAPY7THLINE);
		result.add(CHEMOTHERAPY8THLINE);
		result.add(CHEMOTHERAPY9THLINE);
		result.add(CHEMOTHERAPY10THLINE);
		result.add(TKI2NDLINE);
		result.add(TKI3RDLINE);
		result.add(TKI4THLINE);
		return result;
	}
	public static DrugTherapyType[] getNegativeInstances()
	{
		DrugTherapyType[] instances = new DrugTherapyType[19];
		instances[0] = HORMONE_THERAPY;
		instances[1] = HIGHCOSTDRUG;
		instances[2] = BIPHOSPHONATES;
		instances[3] = IMMUNOTHERAPY;
		instances[4] = OTHER;
		instances[5] = TKI;
		instances[6] = CHEMOTHERAPY1STLINE;
		instances[7] = CHEMOTHERAPY2NDLINE;
		instances[8] = CHEMOTHERAPY3RDLINE;
		instances[9] = CHEMOTHERAPY4THLINE;
		instances[10] = CHEMOTHERAPY5THLINE;
		instances[11] = CHEMOTHERAPY6THLINE;
		instances[12] = CHEMOTHERAPY7THLINE;
		instances[13] = CHEMOTHERAPY8THLINE;
		instances[14] = CHEMOTHERAPY9THLINE;
		instances[15] = CHEMOTHERAPY10THLINE;
		instances[16] = TKI2NDLINE;
		instances[17] = TKI3RDLINE;
		instances[18] = TKI4THLINE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[19];
		negativeInstances[0] = "HORMONE_THERAPY";
		negativeInstances[1] = "HIGHCOSTDRUG";
		negativeInstances[2] = "BIPHOSPHONATES";
		negativeInstances[3] = "IMMUNOTHERAPY";
		negativeInstances[4] = "OTHER";
		negativeInstances[5] = "TKI";
		negativeInstances[6] = "CHEMOTHERAPY1STLINE";
		negativeInstances[7] = "CHEMOTHERAPY2NDLINE";
		negativeInstances[8] = "CHEMOTHERAPY3RDLINE";
		negativeInstances[9] = "CHEMOTHERAPY4THLINE";
		negativeInstances[10] = "CHEMOTHERAPY5THLINE";
		negativeInstances[11] = "CHEMOTHERAPY6THLINE";
		negativeInstances[12] = "CHEMOTHERAPY7THLINE";
		negativeInstances[13] = "CHEMOTHERAPY8THLINE";
		negativeInstances[14] = "CHEMOTHERAPY9THLINE";
		negativeInstances[15] = "CHEMOTHERAPY10THLINE";
		negativeInstances[16] = "TKI2NDLINE";
		negativeInstances[17] = "TKI3RDLINE";
		negativeInstances[18] = "TKI4THLINE";
		return negativeInstances;
	}
	public static DrugTherapyType getNegativeInstance(String name)
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
	public static DrugTherapyType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		DrugTherapyType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1251026;
	public static final DrugTherapyType HORMONE_THERAPY = new DrugTherapyType(-1976, "Hormone Therapy", true, null, null, Color.Default);
	public static final DrugTherapyType HIGHCOSTDRUG = new DrugTherapyType(-1977, "High Cost Drug", true, null, null, Color.Default);
	public static final DrugTherapyType BIPHOSPHONATES = new DrugTherapyType(-1978, "Biphosphonates", true, null, null, Color.Default);
	public static final DrugTherapyType IMMUNOTHERAPY = new DrugTherapyType(-1979, "Immunotherapy", true, null, null, Color.Default);
	public static final DrugTherapyType OTHER = new DrugTherapyType(-1980, "Other", true, null, null, Color.Default);
	public static final DrugTherapyType TKI = new DrugTherapyType(-1995, "TKI", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY1STLINE = new DrugTherapyType(-1996, "Chemotherapy 1st Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY2NDLINE = new DrugTherapyType(-1997, "Chemotherapy 2nd Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY3RDLINE = new DrugTherapyType(-1998, "Chemotherapy 3rd Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY4THLINE = new DrugTherapyType(-1999, "Chemotherapy 4th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY5THLINE = new DrugTherapyType(-2000, "Chemotherapy 5th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY6THLINE = new DrugTherapyType(-2001, "Chemotherapy 6th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY7THLINE = new DrugTherapyType(-2002, "Chemotherapy 7th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY8THLINE = new DrugTherapyType(-2003, "Chemotherapy 8th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY9THLINE = new DrugTherapyType(-2004, "Chemotherapy 9th Line", true, null, null, Color.Default);
	public static final DrugTherapyType CHEMOTHERAPY10THLINE = new DrugTherapyType(-2005, "Chemotherapy 10th Line", true, null, null, Color.Default);
	public static final DrugTherapyType TKI2NDLINE = new DrugTherapyType(-2006, "TKI 2nd Line", true, null, null, Color.Default);
	public static final DrugTherapyType TKI3RDLINE = new DrugTherapyType(-2007, "TKI 3rd Line", true, null, null, Color.Default);
	public static final DrugTherapyType TKI4THLINE = new DrugTherapyType(-2008, "TKI 4th Line", true, null, null, Color.Default);
}
