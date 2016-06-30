/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.bluefloyd.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author jbaiza
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Project {
  private String id;
  private String key;
  private String self;
  private String name;

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the self
   */
  public String getSelf() {
    return self;
  }

  /**
   * @param self the self to set
   */
  public void setSelf(String self) {
    this.self = self;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
}
