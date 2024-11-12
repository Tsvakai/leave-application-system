package zw.co.psc.leaveapplicationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;
import zw.co.psc.leaveapplicationsystem.service.EmailNotificationService;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    @Autowired
    public EmailNotificationServiceImpl(JavaMailSender mailSender) {
    }

    @Override
    public void sendLeaveSubmissionNotification(LeaveApplication leaveApplication) {
        // Compose and send email notification for leave submission
    }

    @Override
    public void sendStatusUpdateNotification(LeaveApplication leaveApplication) {
        // Compose and send email notification for status update
    }
}
