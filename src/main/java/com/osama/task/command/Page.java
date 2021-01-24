package com.osama.task.command;
import static com.osama.task.utils.MessageManager.NONE_MESSAGE_KEY;

/**
 * Class describes page url.
 *
 * @author Osama Alfaqeeh
 */
public class Page {

    public static final String SHOW_ALL_STUDENT_INFORMATION_PAGE_PATH ="/show_all_students_information.jsp";
    public static final String ERROR_PAGE_PATH = "/error.jsp";
    public static final String LOGIN_PAGE_PATH = "/login.jsp";


    private String pageUrl;
    private boolean isRedirect;
    private String messageKey;

    /**
     * Instantiates a new Page.
     *
     * @param pageUrl    the page's url.
     * @param isRedirect boolean value of variable isRedirect;
     */
    public Page(String pageUrl, boolean isRedirect) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
        this.messageKey = NONE_MESSAGE_KEY;
    }

    /**
     * Instantiates a new Page.
     */
    public Page() {
    }

    /**
     * Instantiates a new Page.
     *
     * @param pageUrl    the page's url.
     * @param isRedirect boolean value of variable isRedirect;
     * @param messageKey the message key.
     */
    public Page(String pageUrl, boolean isRedirect, String messageKey) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
        this.messageKey = messageKey;
    }

    /**
     * Gets page url.
     *
     * @return the page's url.
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * Sets page url.
     *
     * @param pageUrl the page's url.
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * Get isRedirect value.
     *
     * @return boolean value of isRedirect variable.
     */
    public boolean isRedirect() {
        return isRedirect;
    }

    /**
     * Sets isRedirect value.
     *
     * @param redirect the boolean value.
     */
    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    /**
     * Gets message key.
     *
     * @return the message key.
     */
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * Sets the message key.
     *
     * @param messageKey the message key.
     */
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}


