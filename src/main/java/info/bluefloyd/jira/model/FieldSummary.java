package info.bluefloyd.jira.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Field Summary. Used as part of the issue summary, encapsulates the "summary"
 * field.
 * 
 * @author Ian Sparkes, Swisscom AG
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class FieldSummary {
  private String summary;
  private Project project;
  private List<VersionSummary> versions;
  private List<VersionSummary> fixVersions;


  /**
   * @return the summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * @param summary the summary to set
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * @return the versions
   */
  public List<VersionSummary> getVersions() {
    return versions;
  }

  /**
   * @param versions the versions to set
   */
  public void setVersions(List<VersionSummary> versions) {
    this.versions = versions;
  }

  /**
   * @return the fixVersions
   */
  public List<VersionSummary> getFixVersions() {
    return fixVersions;
  }

  /**
   * @param fixVersions the fixVersions to set
   */
  public void setFixVersions(List<VersionSummary> fixVersions) {
    this.fixVersions = fixVersions;
  }
  
  /**
   * @return the project
   */
  public Project getProject() {
    return project;
  }

  /**
   * @param project the project to set
   */
  public void setProject(Project project) {
    this.project = project;
  }
}
