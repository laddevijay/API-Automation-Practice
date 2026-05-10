package TestData;
import java.util.List;

import POJO.Address;
import POJO.Member;
import POJO.PersonalInfo;
import POJO.Plan;

public class CreateMember {

    public static Member createMember() {

        // 🔹 Personal Info
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName("Vini");
        personalInfo.setLastName("User");
        personalInfo.setDob("1980-01-01");
        personalInfo.setSsn("111-42-3333");
        personalInfo.setLanguage("English");

        // 🔹 Address
        Address address = new Address();
        address.setStreet("Java Street");
        address.setCity("Pune");
        address.setState("MH");
        address.setZip("411001");

        // 🔹 Plan
        Plan plan = new Plan();
        plan.setPlanName("Silver Plan");
        plan.setPlanType("Dental");
        plan.setStatus("Primary");

        // 🔹 Member
        Member member = new Member();
        member.setEnrollmentId("834-1013");
        member.setPersonalInfo(personalInfo);
        member.setAddress(address);
        member.setMbi("1AB2-RD3-EF45");
        member.setEnrollmentPlans(List.of(plan));
        member.setMemberId(13);

        return member;
    }
}
