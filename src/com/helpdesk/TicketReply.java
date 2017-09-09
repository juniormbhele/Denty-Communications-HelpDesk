package com.helpdesk;

import java.sql.Date;

/**
 * Created by Sphiwe.Mbhele on 2017/09/09.
 */
public class TicketReply
{
    private int TICKETSID;
    private String TRTITLE;
    private String TRDESCRIPTION;
    private Date   POSTEDON;
    private String POSTEDBY;

    public int getTICKETSID() {
        return TICKETSID;
    }

    public void setTICKETSID(int TICKETSID) {
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

    public Date getPOSTEDON() {
        return POSTEDON;
    }

    public void setPOSTEDON(Date POSTEDON) {
        this.POSTEDON = POSTEDON;
    }

    public String getPOSTEDBY() {
        return POSTEDBY;
    }

    public void setPOSTEDBY(String POSTEDBY) {
        this.POSTEDBY = POSTEDBY;
    }
}
