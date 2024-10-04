package com.keerk99.newjobplatform.domain.job;

public class JobMapper {
    public static Job toJob(CreateJob createJob) {
        Job job = new Job();
        job.setTitle(createJob.title());
        job.setDescription(createJob.description());
        job.setMinSalary(createJob.minSalary());
        job.setMaxSalary(createJob.maxSalary());
        job.setLocation(createJob.location());
        job.setCompany(createJob.company());
        return job;
    }

    public static DataListJob toDataListJob(Job job) {
        return new DataListJob(job);
    }

    public static void toJobUpdate(UpdateJob updateJob, Job job) {
        job.setTitle(updateJob.title());
        job.setDescription(updateJob.description());
        job.setMinSalary(updateJob.minSalary());
        job.setMaxSalary(updateJob.maxSalary());
        job.setLocation(updateJob.location());
    }
}
