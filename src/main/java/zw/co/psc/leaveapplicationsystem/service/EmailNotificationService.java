package zw.co.psc.leaveapplicationsystem.service;

import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;

public interface EmailNotificationService {
    void sendLeaveSubmissionNotification(LeaveApplication leaveApplication);
    void sendStatusUpdateNotification(LeaveApplication leaveApplication);
}
