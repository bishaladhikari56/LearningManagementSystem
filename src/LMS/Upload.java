/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS;

/**
 *
 * @author Michelle
 */
public class Upload {
    private int id;
    private String courseID, teacherID, assignmentName;
    private byte[] pic, txt;

    public Upload(int id, String courseID, String teacherID, String assignmentName, byte[] pic, byte[] txt) {
        this.id = id;
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.assignmentName = assignmentName;
        this.pic = pic;
        this.txt = txt;
    }
    
    public int getID(){
        return id;
    }

    public String getCourseID() {
        return courseID;
    }
    
    public String getTeacherID() {
        return teacherID;
    }
    
     public String getAssignmentName() {
        return assignmentName;
    }

    public byte[] getPic() {
        return pic;
    }
    
    public byte[] getTxt() {
        return txt;
    }
}
