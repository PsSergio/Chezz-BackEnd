package com.api.chezz.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SessionPlayer")
@Getter
@Setter
public class Session {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "playerId")
    @OneToOne
    private Player player;

    @Column(name="init_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime initDate;

    @Column(name="final_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime finalDate;

    public void setAllDatesTime(){
        this.initDate = LocalDateTime.now();
        this.finalDate = LocalDateTime.now().plusSeconds(300); // 5min
    }

    public Boolean isSessionValid(){
        return LocalDateTime.now().isBefore(this.finalDate);
    }

}
