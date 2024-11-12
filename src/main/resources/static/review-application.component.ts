// @ts-ignore
import { Component, OnInit } from '@angular/core';
// @ts-ignore
import { LeaveApplicationService } from '../services/leave-application.service';

@Component({
    selector: 'app-review-application',
    templateUrl: './review-application.component.html',
    styleUrls: ['./review-application.component.css']
})
export class ReviewApplicationComponent implements OnInit {
    pendingApplications = [];

    constructor(private leaveService: LeaveApplicationService) {
    }

    ngOnInit() {
        this.leaveService.getPendingApplications().subscribe(
            (data: any) => this.pendingApplications = data,
            error => alert('Error loading pending applications.')
        );
    }

    approveLeave(leaveId: string) {
        this.leaveService.updateLeaveStatus(leaveId, 'Approved').subscribe(
            response => {
                alert('Leave application approved.');
                this.ngOnInit();
            },
            error => alert('Error approving leave.')
        );
    }
    rejectLeave(leaveId: string) {
        this.leaveService.updateLeaveStatus(leaveId, 'Rejected').subscribe(
            response => {
                alert('Leave application rejected.');
                this.ngOnInit();
            },
            error => alert('Error rejecting leave.')
        );
    }
}