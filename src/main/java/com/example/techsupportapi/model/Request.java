package com.example.techsupportapi.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

        private Integer id;
        private String applicantName;
        private LocalDateTime requestDate;
        private String topic;
        private String description;
        private String status;
        private String attendedBy;
        private LocalDateTime attendedAt;
        private LocalDateTime lastEditedAt;

        public Request() {

        }

        public Request(@JsonProperty("applicantName") String applicantName,
                        @JsonProperty("topic") String topic,
                        @JsonProperty("description") String description) {
                this.applicantName = applicantName;
                this.topic = topic;
                this.description = description;
                this.status = "Pendiente";
                this.requestDate = LocalDateTime.now();
        }

        // Getters y Setters
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getApplicantName() {
                return applicantName;
        }

        public void setApplicantName(String applicantName) {
                this.applicantName = applicantName;
        }

        public LocalDateTime getRequestDate() {
                return requestDate;
        }

        public void setRequestDate(LocalDateTime requestDate) {
                this.requestDate = requestDate;
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

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getAttendedBy() {
                return attendedBy;
        }

        public void setAttendedBy(String attendedBy) {
                this.attendedBy = attendedBy;
        }

        public LocalDateTime getAttendedAt() {
                return attendedAt;
        }

        public void setAttendedAt(LocalDateTime attendedAt) {
                this.attendedAt = attendedAt;
        }

        public LocalDateTime getLastEditedAt() {
                return lastEditedAt;
        }

        public void setLastEditedAt(LocalDateTime lastEditedAt) {
                this.lastEditedAt = lastEditedAt;
        }
}
