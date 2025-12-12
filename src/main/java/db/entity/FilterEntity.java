package db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "filters") // назва таблиці в БД
public class FilterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filter_name")
    private String filterName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    // Конструктори
    public FilterEntity() {}
    public FilterEntity(String filterName, String createdBy, java.sql.Timestamp createdAt) {
        this.filterName = filterName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // Геттери та сеттери
    public int getId() { return id; }
    public String getFilterName() { return filterName; }
    public void setFilterName(String filterName) { this.filterName = filterName; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public java.sql.Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.sql.Timestamp createdAt) { this.createdAt = createdAt; }
}
