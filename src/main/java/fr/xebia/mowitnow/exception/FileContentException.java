/**
 * 
 */
package fr.xebia.mowitnow.exception;

/**
 * @author Charles Dufour
 *
 */
public class FileContentException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 6368973728424234324L;
    private String contentIssue;

    public FileContentException(String contentIssue) {
        this.contentIssue = contentIssue;
    }

    /**
     * @return the contentIssue
     */
    public String getContentIssue() {
        return contentIssue;
    }

    /**
     * @param contentIssue
     *            the contentIssue to set
     */
    public void setContentIssue(String contentIssue) {
        this.contentIssue = contentIssue;
    }
}
