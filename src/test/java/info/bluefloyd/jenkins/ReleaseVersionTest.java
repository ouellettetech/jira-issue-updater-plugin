package info.bluefloyd.jenkins;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.bluefloyd.jira.model.IssueSummaryList;
import info.bluefloyd.jira.model.VersionSummary;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test case for Issue
 *
 * https://issues.jenkins-ci.org/browse/JENKINS-31755
 *
 * @author ian
 */
public class ReleaseVersionTest {

  /**
   * JSON parsing fails when managed versions are used. Fixed by adding
   * VersionSummary class to the model.
   *
   * @throws java.io.IOException
   */
  @Test
  public void TestFieldSummaryWithVersions() throws IOException {

    String issueSummaryRESTResult = "{\n"
            + "   \"expand\":\"names,schema\",\n"
            + "   \"startAt\":0,\n"
            + "   \"maxResults\":1000,\n"
            + "   \"total\":1,\n"
            + "   \"issues\":[\n"
            + "      {\n"
            + "         \"expand\":\"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\n"
            + "         \"id\":\"289777\",\n"
            + "         \"self\":\"https://tallyjira.tallysolutions.com/rest/api/2/issue/289777\",\n"
            + "         \"key\":\"TE-25246\",\n"
            + "         \"fields\":{\n"
            + "            \"summary\":\"VAT Internal - TIN is not getting updated in Ledger even after incorrect TIN matches with Master.\",\n"
            + "            \"versions\":[\n"
            + "               {\n"
            + "                  \"self\":\"https://tallyjira.tallysolutions.com/rest/api/2/version/12443\",\n"
            + "                  \"id\":\"12443\",\n"
            + "                  \"description\":\"Series A Release 5.0\",\n"
            + "                  \"name\":\"Series A Release 5.0\",\n"
            + "                  \"archived\":false,\n"
            + "                  \"released\":true,\n"
            + "                  \"releaseDate\":\"2015-08-03\"\n"
            + "               }\n"
            + "            ]\n"
            + "         }\n"
            + "      }\n"
            + "   ]\n"
            + "}";

    ObjectMapper mapper = new ObjectMapper();
    IssueSummaryList summaryList = mapper.readValue(issueSummaryRESTResult, IssueSummaryList.class);

    assertNotNull(summaryList);
    assertEquals(1, summaryList.getIssues().size());
    assertEquals(1, summaryList.getIssues().get(0).getFields().getVersions().size());
    VersionSummary version = summaryList.getIssues().get(0).getFields().getVersions().get(0);
    assertFalse(version.isArchived());
    assertTrue(version.isReleased());
    assertEquals("12443", version.getId());
  }
}
