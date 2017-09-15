package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/09/07.
 */
public class Responses
{

    private String  TICKETSID;
    private String TRTITLE;
    private String TRDESCRIPTION;
    private String POSTEDON;
    private String POSTEDBY;



    public String getTICKETSID() {
        return TICKETSID;
    }

    public void setTICKETSID(String TICKETSID) {
        this.TICKETSID = TICKETSID;
    }

    public String getTRTITLE() {
        return TRTITLE;
    }

    public void setTRTITLE(String TRTITLE) {
        this.TRTITLE = TRTITLE;
    }

    public String getTRDESCRIPTION() {
        return TRDESCRIPTION;
    }

    public void setTRDESCRIPTION(String TRDESCRIPTION) {
        this.TRDESCRIPTION = TRDESCRIPTION;
    }

    public String getPOSTEDON() {
        return POSTEDON;
    }

    public void setPOSTEDON(String POSTEDON) {
        this.POSTEDON = POSTEDON;
    }

    public String getPOSTEDBY() {
        return POSTEDBY;
    }

    public void setPOSTEDBY(String POSTEDBY) {
        this.POSTEDBY = POSTEDBY;
    }
}

