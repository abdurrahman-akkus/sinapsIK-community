/*
 * Copyright (C) 2019 Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.general;

import com.sinapsIK.iSuper.ISuperEntity;
import com.sinapsIK.util.HashMapConverter;
import com.sinapsIK.util.ListConverter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bant içi kontrolcülerin ara kontrol formuna karşılık gelen forma ait
 * modeldir.
 */
@Data
@Entity
@Table(name = "general")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GeneralEntity implements ISuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity")
    private String identity;

    @Column(name = "date_of_birth")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "nation")
    private String nation;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gsm")
    private String gsm;

    @Column(name = "email")
    private String email;
        
    @Column(name="address")
    private String address;
    
    @Convert(converter = HashMapConverter.class)
    @Column(name="military")
    private Map<String, Object> military;

    @Convert(converter = ListConverter.class)
    @Column(name = "driver_licences")
    private List<Object> driverLicences;
    
    @Column(name="father_name")
    private String fatherName;
    
    @Column(name="father_job")
    private String fatherJob;
    
    @Column(name="mother_name")
    private String motherName;
    
    @Column(name="mother_job")
    private String motherJob;
    
    @Column(name="siblings_count")
    private int siblingsCount;

    @Convert(converter = HashMapConverter.class)
    @Column(name = "marital")
    private Map<String, Object> marital;

    @Convert(converter = ListConverter.class)
    @Column(name = "schools")
    private List<Object> schools;

    @Convert(converter = ListConverter.class)
    @Column(name = "courses")
    private List<Object> courses;
    
    @Column(name="education_level")
    private String educationLevel;

    @Convert(converter = ListConverter.class)
    @Column(name = "experiences")
    private List<Object> experiences;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "foreign_languages")
    private List<Object> foreignLanguages;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "programs")
    private List<Object> programs;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "office_equipments")
    private List<Object> officeEquipments;
    
    @Column(name="lives_with")
    private String livesWith;
    
    @Column(name="home_ownership")
    private String homeOwnership;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "illnesses")
    private List<Object> illnesses;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "jobs")
    private List<Object> jobs;
    
    @Column(name="any_salary")
    private String anySalary;
    
    @Column(name="salary")
    private int salary;
    
    @Column(name="asap")
    private String asap;
    
    @UpdateTimestamp
    @Column(name = "start_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
      
    @Column(name="last_statement")
    private String lastStatement;
    
    @Convert(converter = ListConverter.class)
    @Column(name = "credentials")
    private List<Object> credentials;
    
    @CreationTimestamp
    @Column(name = "request_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date requestDate;
    
    @Column(name="law_conformation")
    private String lawConformation;
    
    @ColumnDefault("1")
    @Column(name="is_active",columnDefinition = "int default 1")
    private String isActive;
    
    @ColumnDefault("0")
    @Column(name="is_seen")
    private String isSeen;
    
}
