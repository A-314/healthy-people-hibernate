package com.emelian.dao;

import com.emelian.model.Patient;
import com.emelian.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class PatientDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PatientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Patient> index() {
        Session session;
      session = sessionFactory.openSession();
        return session.createQuery("select p from Patient p", Patient.class).getResultList();
    }
    @Transactional
    public Patient show(int id){
        Session session;
        try {  session = sessionFactory.getCurrentSession();
        }catch(HibernateException e){session = sessionFactory.openSession();}
        return session.get(Patient.class,id);
    }
    @Transactional
    public void save(Patient patient, Person person){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch(HibernateException e){session = sessionFactory.openSession();
            e.printStackTrace();}
        session.save(person);
        session.save(patient);
    }
    @Transactional
    public void update(int id,Patient updatePatient){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        }catch(HibernateException e){session = sessionFactory.openSession();
            e.printStackTrace();}
        session.update(updatePatient);

    }
    @Transactional
    public void delete(int id){
        Session session ;
        try {session = sessionFactory.getCurrentSession();
        }catch(HibernateException e){session = sessionFactory.openSession();}

        try {
            Patient patient =  session.get(Patient.class, id);
            session.delete(patient);
        }catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }}
