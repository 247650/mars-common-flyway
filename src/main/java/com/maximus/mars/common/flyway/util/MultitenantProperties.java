/**
 * 
 */
package com.maximus.mars.common.flyway.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 80759
 *
 */
@Configuration
@ConfigurationProperties("multitenant")
public class MultitenantProperties 
{
	private List<Database> databases = new ArrayList<>();
	
	public static class Database
	{
		private String name;
	    private String url;
	    private String username;
	    private String password;        
	    private String locations;
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getLocations() {
			return locations;
		}
		public void setLocations(String locations) {
			this.locations = locations;
		}
	}

	public List<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(List<Database> databases) {
		this.databases = databases;
	}
}
