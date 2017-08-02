package com.figo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PcbDesignStore {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.PN
     *
     * @mbggenerated
     */
    private String pn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.temp_PN
     *
     * @mbggenerated
     */
    private String tempPn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.ver
     *
     * @mbggenerated
     */
    private String ver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.user_upload
     *
     * @mbggenerated
     */
    private String userUpload;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.date_upload
     *
     * @mbggenerated
     */
    private Date dateUpload;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.user_modified
     *
     * @mbggenerated
     */
    private String userModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.date_modified
     *
     * @mbggenerated
     */
    private Date dateModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.approver
     *
     * @mbggenerated
     */
    private String approver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.date_approved
     *
     * @mbggenerated
     */
    private Date dateApproved;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.path_sch
     *
     * @mbggenerated
     */
    private String pathSch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.path_layout
     *
     * @mbggenerated
     */
    private String pathLayout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.path_gerber
     *
     * @mbggenerated
     */
    private String pathGerber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.path_pcbdraw
     *
     * @mbggenerated
     */
    private String pathPcbdraw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pcb_design_store.path_pcbchecklist
     *
     * @mbggenerated
     */
    private String pathPcbchecklist;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.id
     *
     * @return the value of pcb_design_store.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.id
     *
     * @param id the value for pcb_design_store.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.PN
     *
     * @return the value of pcb_design_store.PN
     *
     * @mbggenerated
     */
    public String getPn() {
        return pn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.PN
     *
     * @param pn the value for pcb_design_store.PN
     *
     * @mbggenerated
     */
    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.temp_PN
     *
     * @return the value of pcb_design_store.temp_PN
     *
     * @mbggenerated
     */
    public String getTempPn() {
        return tempPn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.temp_PN
     *
     * @param tempPn the value for pcb_design_store.temp_PN
     *
     * @mbggenerated
     */
    public void setTempPn(String tempPn) {
        this.tempPn = tempPn == null ? null : tempPn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.status
     *
     * @return the value of pcb_design_store.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.status
     *
     * @param status the value for pcb_design_store.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.ver
     *
     * @return the value of pcb_design_store.ver
     *
     * @mbggenerated
     */
    public String getVer() {
        return ver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.ver
     *
     * @param ver the value for pcb_design_store.ver
     *
     * @mbggenerated
     */
    public void setVer(String ver) {
        this.ver = ver == null ? null : ver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.user_upload
     *
     * @return the value of pcb_design_store.user_upload
     *
     * @mbggenerated
     */
    public String getUserUpload() {
        return userUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.user_upload
     *
     * @param userUpload the value for pcb_design_store.user_upload
     *
     * @mbggenerated
     */
    public void setUserUpload(String userUpload) {
        this.userUpload = userUpload == null ? null : userUpload.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.date_upload
     *
     * @return the value of pcb_design_store.date_upload
     *
     * @mbggenerated
     */

    public Date getDateUpload() {
        return dateUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.date_upload
     *
     * @param dateUpload the value for pcb_design_store.date_upload
     *
     * @mbggenerated
     */
    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.user_modified
     *
     * @return the value of pcb_design_store.user_modified
     *
     * @mbggenerated
     */
    public String getUserModified() {
        return userModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.user_modified
     *
     * @param userModified the value for pcb_design_store.user_modified
     *
     * @mbggenerated
     */
    public void setUserModified(String userModified) {
        this.userModified = userModified == null ? null : userModified.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.date_modified
     *
     * @return the value of pcb_design_store.date_modified
     *
     * @mbggenerated
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.date_modified
     *
     * @param dateModified the value for pcb_design_store.date_modified
     *
     * @mbggenerated
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.approver
     *
     * @return the value of pcb_design_store.approver
     *
     * @mbggenerated
     */
    public String getApprover() {
        return approver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.approver
     *
     * @param approver the value for pcb_design_store.approver
     *
     * @mbggenerated
     */
    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.date_approved
     *
     * @return the value of pcb_design_store.date_approved
     *
     * @mbggenerated
     */
    public Date getDateApproved() {
        return dateApproved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.date_approved
     *
     * @param dateApproved the value for pcb_design_store.date_approved
     *
     * @mbggenerated
     */
    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.path_sch
     *
     * @return the value of pcb_design_store.path_sch
     *
     * @mbggenerated
     */
    public String getPathSch() {
        return pathSch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.path_sch
     *
     * @param pathSch the value for pcb_design_store.path_sch
     *
     * @mbggenerated
     */
    public void setPathSch(String pathSch) {
        this.pathSch = pathSch == null ? null : pathSch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.path_layout
     *
     * @return the value of pcb_design_store.path_layout
     *
     * @mbggenerated
     */
    public String getPathLayout() {
        return pathLayout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.path_layout
     *
     * @param pathLayout the value for pcb_design_store.path_layout
     *
     * @mbggenerated
     */
    public void setPathLayout(String pathLayout) {
        this.pathLayout = pathLayout == null ? null : pathLayout.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.path_gerber
     *
     * @return the value of pcb_design_store.path_gerber
     *
     * @mbggenerated
     */
    public String getPathGerber() {
        return pathGerber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.path_gerber
     *
     * @param pathGerber the value for pcb_design_store.path_gerber
     *
     * @mbggenerated
     */
    public void setPathGerber(String pathGerber) {
        this.pathGerber = pathGerber == null ? null : pathGerber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.path_pcbdraw
     *
     * @return the value of pcb_design_store.path_pcbdraw
     *
     * @mbggenerated
     */
    public String getPathPcbdraw() {
        return pathPcbdraw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.path_pcbdraw
     *
     * @param pathPcbdraw the value for pcb_design_store.path_pcbdraw
     *
     * @mbggenerated
     */
    public void setPathPcbdraw(String pathPcbdraw) {
        this.pathPcbdraw = pathPcbdraw == null ? null : pathPcbdraw.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pcb_design_store.path_pcbchecklist
     *
     * @return the value of pcb_design_store.path_pcbchecklist
     *
     * @mbggenerated
     */
    public String getPathPcbchecklist() {
        return pathPcbchecklist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pcb_design_store.path_pcbchecklist
     *
     * @param pathPcbchecklist the value for pcb_design_store.path_pcbchecklist
     *
     * @mbggenerated
     */
    public void setPathPcbchecklist(String pathPcbchecklist) {
        this.pathPcbchecklist = pathPcbchecklist == null ? null : pathPcbchecklist.trim();
    }
}