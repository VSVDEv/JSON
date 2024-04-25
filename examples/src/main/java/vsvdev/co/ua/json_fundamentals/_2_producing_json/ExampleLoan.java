package vsvdev.co.ua.json_fundamentals._2_producing_json;

import vsvdev.co.ua.json_fundamentals.common.Job;
import vsvdev.co.ua.json_fundamentals.common.LoanApplication;
import vsvdev.co.ua.json_fundamentals.common.LoanDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.JULY;

public class ExampleLoan {
    public static final LoanApplication LOAN_APPLICATION;

    static {
        final LoanDetails loanDetails = new LoanDetails();
        loanDetails.setAmount(10000.00);
        loanDetails.setStartDate(LocalDate.of(2024, JULY, 7));
        loanDetails.setEndDate(LocalDate.of(2025, JULY, 7));

        final List<Job> jobs = new ArrayList<>();

        Job job = new Job();
        job.setTitle("Java Developer");
        job.setAnnualIncome(5000);
        job.setYearsActive(3);
        jobs.add(job);

        job = new Job();
        job.setTitle("Team Leader");
        job.setAnnualIncome(20000);
        job.setYearsActive(8);
        jobs.add(job);

        job = new Job();
        job.setTitle("Author");
        job.setAnnualIncome(7000);
        job.setYearsActive(1);
        jobs.add(job);

        LOAN_APPLICATION = new LoanApplication();
        LOAN_APPLICATION.setName("Mrs Sam Lee");
        LOAN_APPLICATION.setPurposeOfLoan("To build an extension to my house");
        LOAN_APPLICATION.setLoanDetails(loanDetails);
        LOAN_APPLICATION.setJobs(jobs);
    }
}
