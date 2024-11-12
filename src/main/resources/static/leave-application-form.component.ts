// @ts-ignore
import { Component } from '@angular/core';
// @ts-ignore
import { LeaveApplicationService } from '../services/leave-application-form.service';

@Component({
    selector: 'app-leave-application-form',
    templateUrl: './leave-application-form.component.html',
    styleUrls: ['./leave-application-form.component.css']
})
export class LeaveApplicationFormComponent {
    leaveRequest = { startDate: '', endDate: '', leaveType: '' };

    constructor(private leaveService: LeaveApplicationService) {}

    onSubmit() {
        this.leaveService.applyLeave(this.leaveRequest).subscribe(
            response => alert('Leave application submitted successfully!'),
            error => alert('Error submitting leave application.')
        );
    }
}