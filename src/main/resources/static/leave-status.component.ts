// @ts-ignore
import { Component, OnInit } from '@angular/core';
// @ts-ignore
import { LeaveApplicationService } from '../services/leave-application.service';

@Component({
    selector: 'app-leave-status',
    templateUrl: './leave-status.component.html',
    styleUrls: ['./leave-status.component.css']
})
export class LeaveStatusComponent implements OnInit {
    leaveApplications = [];

    constructor(private leaveService: LeaveApplicationService) {}

    ngOnInit() {
        this.leaveService.getLeaveStatus().subscribe(
            (data: any) => this.leaveApplications = data,
            error => alert('Error loading leave status.')
        );
    }

    cancelLeave(leaveId: string) {
        this.leaveService.cancelLeave(leaveId).subscribe(
            response => {
                alert('Leave application canceled.');
                this.ngOnInit();  // Refresh the status list
            },
            error => alert('Error canceling leave.')
        );
    }
}