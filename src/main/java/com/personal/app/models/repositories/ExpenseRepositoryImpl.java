package com.personal.app.models.repositories;

import java.util.List;

import com.personal.app.models.entities.Expense;

public class ExpenseRepositoryImpl extends GenericRepository<Expense> {


    private static ExpenseRepositoryImpl instance;

    public static ExpenseRepositoryImpl getInstance() {
        if(instance == null) {
            instance = new ExpenseRepositoryImpl();
        }
        return instance;
    }

    private ExpenseRepositoryImpl() {
        super(Expense.class);
    }

    @Override
    public void insert(Expense expense) {
        super.insert(expense);
    }

    @Override
    public List<Expense> findAll() {
        return super.findAll();
    }


    // Quest implementazione valeva quando non avevo centralizzato l'uso dell'Entity Manager
    // Questa classe implementava un interfaccia della repo che utilizzava al suo interno Hibernate
    // overiddando i suoi metodi
    /*

        private final SessionFactory sessionFactory; 

        public ExpenseRepositoryImpl() {
            this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        }

        @Override
        public void save(Expense expense) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.persist(expense);
                session.getTransaction().commit();

                System.out.println("Saved: " + expense);
            }
        }

        @Override
        public List<Expense> findAll() {

            Transaction tx = null;
            List<Expense> expenses;

            try (Session session = sessionFactory.openSession()) {
                tx = session.beginTransaction();
                expenses = session.createQuery("FROM Expense", Expense.class).list();
                tx.commit();
            } catch (Exception e) {
                System.err.println("Si incazza si brutto");
                if (tx != null) tx.rollback();
                throw e;
            }

            return expenses;
        }
     * 
     */

}