package com.example.techsupportapi.model;

import java.time.LocalDateTime;

public class Request {

        private long id;
        private String applicantName;
        private String topic;
        private String description;
        private LocalDateTime requestDate;
        private String status;

        public Request() {
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getApplicantName() {
                return applicantName;
        }

        public void setApplicantName(String applicantName) {
                this.applicantName = applicantName;
        }

        public String getTopic() {
                return topic;
        }

        public void setTopic(String topic) {
                this.topic = topic;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public LocalDateTime getRequestDate() {
                return requestDate;
        }

        public void setRequestDate(LocalDateTime requestDate) {
                this.requestDate = requestDate;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
