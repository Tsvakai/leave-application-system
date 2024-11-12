// @ts-ignore
import { Injectable } from '@angular/core';
// @ts-ignore
import { HttpClient } from '@angular/common/http';
// @ts-ignore
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LeaveApplicationService {
    private apiUrl = '/api/leaves';

    constructor(private http: HttpClient) {}

    applyLeave(data: any): Observable<any> {
        return this.http.post(`${this.apiUrl}/apply`, data);
    }

    getLeaveStatus(leaveId: string): Observable<any> {
        return this.http.get(`${this.apiUrl}/status/${leaveId}`);
    }

    cancelLeave(leaveId: string): Observable<any> {
        return this.http.put(`${this.apiUrl}/cancel/${leaveId}`, {});
    }

    getPendingApplications(): Observable<any> {
        return this.http.get(`/api/leaves/pending`);
    }
    updateLeaveStatus(leaveId: string, status: string): Observable<any> {
        const payload = { status };
        return this.http.put(`${leaveId}/status`, payload);
    }
}