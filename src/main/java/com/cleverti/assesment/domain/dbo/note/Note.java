package com.cleverti.assesment.domain.dbo.note;

import java.time.LocalDateTime;

import com.cleverti.assesment.domain.dbo.users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "note")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTE")
    Integer id;

    @Column(name = "title", length = 50)
    private String title;
    
    @Column(name = "content", length = 255)    
    private String content;
    
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "fl_active")
    private boolean isActive = true;
    
    @ManyToOne
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;    

}
