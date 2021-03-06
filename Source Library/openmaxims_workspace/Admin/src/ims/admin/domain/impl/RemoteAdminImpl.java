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
// This code was generated by John MacEnri using IMS Development Environment (version 1.50 build 2449.32164)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.sql.Connection;
import java.util.List;

import ims.admin.domain.base.impl.BaseRemoteAdminImpl;
import ims.configuration.AFlag;
import ims.configuration.ClassConfig;
import ims.configuration.ConfigFlag;
import ims.configuration.Configuration;
import ims.configuration.EnvironmentConfig;
import ims.domain.DbType;
import ims.domain.DomainFactory;
import ims.domain.SessionData;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.hibernate3.Registry;
import ims.framework.SessionConstants;
import ims.framework.cn.SessionManager;
import ims.framework.utils.ImagePath;
import ims.utils.Logging;

public class RemoteAdminImpl extends BaseRemoteAdminImpl
{
	private static final long serialVersionUID = 1L;

	public void refreshLookupCache(Integer typeId)
	{
		if (typeId == null)
			return;
		
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.Lookup type = factory.getLookup(typeId.intValue());
		if ( null == type ) {
			throw new DomainRuntimeException("No lookup type exists with ID = " + typeId);	
		}
		factory.refresh(type);
		this.getLookupService().refreshCache(typeId.intValue());
	}

	public void reloadFlags()
	{
		try
		{
			ConfigFlag.reloadFlags();
		}
		catch (Exception e)
		{			
			throw new DomainRuntimeException(e);
		}
	}

	public void saveFlag(String flagName, String flagValue)
	{
		try
		{
			//ConfigFlag.saveFlag(flagName, flagValue);
			AFlag flag = ConfigFlag.getConfigFlag(flagName);			
			if (flag == null) 
				return;			
			flag.setValue(flagValue);
			
			
			if (flagName.equals(ConfigFlag.GEN.LOGGING_LEVEL.getName()))
			{
				Logging.setLoggingLevel(ConfigFlag.GEN.LOGGING_LEVEL.getValue());
			}
			
			//TODO 
			/*else if (flagName.equals(ConfigFlag.GEN.SHOW_SQL.getName()))
			{
				setShowSql(ConfigFlag.GEN.SHOW_SQL.getValue());
			}
			else if (flagName.equals(ConfigFlag.GEN.HIBERNATE_STATISTICS_ENABLED.getName()))
			{
				setHibernateStatisticsEnabled(ConfigFlag.GEN.HIBERNATE_STATISTICS_ENABLED.getValue());
			}
			else if (flagName.equals(ConfigFlag.GEN.FORMAT_SQL.getName()))
			{
				this.getDomainFactory().setFormatSql(ConfigFlag.GEN.FORMAT_SQL.getValue());
			}			
			else if (flagName.equals(ConfigFlag.DOM.MAIN_DATASOURCE_NAME.getName()))
			{
				String dsName = ConfigFlag.DOM.MAIN_DATASOURCE_NAME.getValue();
				this.getDomainFactory().setDatasource(dsName);
				this.reloadConfiguration();
			}			
			else if (flagName.equals(ConfigFlag.DOM.CACHE_PROVIDER.getName()))
			{
				Registry.getInstance().setCacheProvider();
				this.reloadConfiguration();
			}*/
			
			else if (flagName.equals(ConfigFlag.GEN.SESSION_TIMEOUT.getName()))
			{
				SessionManager.setSessionTimeout(ConfigFlag.GEN.SESSION_TIMEOUT.getValue());
			}
			else if (flagName.equals(ConfigFlag.ENABLE_DB_CONNECTION_TRACE.getName()))
			{
				if (this.getDbType().equals(DbType.ORACLE))
				{
					DomainFactory factory = getDomainFactory();		
					Connection conn = factory.getJdbcConnection();
					if (ConfigFlag.ENABLE_DB_CONNECTION_TRACE.getValue())
					{
						//conn.createStatement().execute("ALTER SESSION SET TIMED_STATISTICS = TRUE");
						conn.createStatement().execute("ALTER SESSION SET EVENTS '10046 TRACE NAME CONTEXT FOREVER, LEVEL 4'");						
					}
					else
					{
						//conn.createStatement().execute("ALTER SESSION SET TIMED_STATISTICS = FALSE");
						conn.createStatement().execute("ALTER SESSION SET EVENTS '10046 TRACE NAME CONTEXT OFF'");						
					}
				}
			}
		}
		catch (Exception e)
		{
			throw new DomainRuntimeException(e);
		}
	}
	
	private Configuration getConfiguration()
	{
		SessionData sessData = (SessionData)this.getDomainFactory().getDomainSession().getAttribute(SessionConstants.SESSION_DATA);
		Configuration cfg = sessData.configurationModule.get();
		return cfg;
	}

	public void addImage(Integer imageId, String imagePath)
	{
		ImagePath img = new ImagePath(imageId.intValue(), imagePath);
		getConfiguration().getRegisteredImages().put(imageId, img);
	}

	public void reloadAuditConfig()
	{
		DomainFactory factory = getDomainFactory();		
		List nonAuditBos = factory.find("select na.boClassName from NonAuditObject na");
		ClassConfig cc = getConfiguration().getClassConfig();
		cc.loadNonAuditBos(nonAuditBos);		
	}
}
