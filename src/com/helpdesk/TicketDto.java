package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/09/06.
 */
public class TicketDto
{

    private String TICKETSID;

    public String getTICKETSID() {
        return TICKETSID;
    }

    public void setTICKETSID(String TICKETSID) {
        this.TICKETSID = TICKETSID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getTICKETSTITLE() {
        return TICKETSTITLE;
    }

    public void setTICKETSTITLE(String TICKETSTITLE) {
        this.TICKETSTITLE = TICKETSTITLE;
    }

    public String getTICKETSDESCRIPTION() {
        return TICKETSDESCRIPTION;
    }

    public void setTICKETSDESCRIPTION(String TICKETSDESCRIPTION) {
        this.TICKETSDESCRIPTION = TICKETSDESCRIPTION;
    }

    public String getPOSTEDON() {
        return POSTEDON;
    }

    public void setPOSTEDON(String POSTEDON) {
        this.POSTEDON = POSTEDON;
    }

    public String getRESOLVEDON() {
        return RESOLVEDON;
    }

    public void setRESOLVEDON(String RESOLVEDON) {
        this.RESOLVEDON = RESOLVEDON;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getASSIGNEDTO() {
        return ASSIGNEDTO;
    }

    public void setASSIGNEDTO(String ASSIGNEDTO) {
        this.ASSIGNEDTO = ASSIGNEDTO;
    }

    private String USERNAME;
    private String TICKETSTITLE;
    private String TICKETSDESCRIPTION;
    private String POSTEDON;
    private String STATUS;
    private String RESOLVEDON;
    private String ASSIGNEDTO;
}
