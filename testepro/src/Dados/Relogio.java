package Dados;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relogio extends JFrame {
    private JLabel labelRelogio;

    public Relogio() {
        super("Relógio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelRelogio = new JLabel();
        labelRelogio.setFont(new Font("Arial", Font.PLAIN, 40));
        labelRelogio.setHorizontalAlignment(JLabel.CENTER);

        atualizarRelogio(); // Atualiza o relógio ao iniciar o programa

        // Cria um temporizador para atualizar o relógio a cada segundo
        Timer timer = new Timer(1000, e -> atualizarRelogio());
        timer.start();

        // Adiciona o rótulo ao conteúdo da janela
        getContentPane().add(labelRelogio);

        // Configura o tamanho e exibe a janela
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarRelogio() {
        // Obtém a hora atual
        Date dataAtual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaFormatada = formatoHora.format(dataAtual);

        // Atualiza o rótulo com a hora atual
        labelRelogio.setText(horaFormatada);
    }
}
