import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Tic_Tac_Toe extends JFrame implements ActionListener {

    static JButton[] game_Buttons = new JButton[9]; // Boutons du jeu
    static String[] Buttons = {"", "", "", "", "", "", "", "", ""}; // Tableau représentant l'état du jeu
     
    static JPanel title_panel = new JPanel(); // Le titre du jeu 
    static JLabel game_title = new JLabel("Tic-Tac-Toe");

    static JPanel button_panel = new JPanel(new GridLayout(3, 3)); // panel pour les bouttons du jeu

    Font font = new Font("Arial", Font.BOLD, 50); // Le Style du Font Utilise
    static Random random = new Random();
    
    static boolean is_Ai = true; // Détermine si l'IA commence

    // variable quand le jeu est 2 VS 2
    static boolean is_2v2 = true;   
    static boolean player_1 = true; 


    JButton easyButton = new JButton("Easy");
    JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");
    static int depth;
    
    private void first_frame() {
        
        JPanel outerpanel = new JPanel();
        outerpanel.setLayout(new BorderLayout());
        outerpanel.setBackground(new Color(25, 25, 25)); 
    
        
        JLabel welcome = new JLabel("(: HI! LET'S PLAY :)");
        welcome.setOpaque(true);
        welcome.setFont(new Font("Arial", Font.BOLD, 50)); 
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBackground(new Color(75, 0, 130)); 
        welcome.setForeground(new Color(240, 248, 255)); 
    
        // Inner panel to hold the buttons
        JPanel innerpanel = new JPanel();
        innerpanel.setPreferredSize(new Dimension(400, 100));
        innerpanel.setBackground(new Color(25, 25, 25)); 
        innerpanel.setLayout(new GridBagLayout()); 
    
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
    
        
        JButton button_2v2 = new JButton("2 VS 2");
        button_2v2.setPreferredSize(new Dimension(280, 200)); 
        button_2v2.setFont(new Font("Arial", Font.BOLD, 50)); 
        button_2v2.setFocusable(false);
        button_2v2.setBackground(new Color(144, 238, 144)); 
        button_2v2.setForeground(new Color(75, 0, 130)); 
        button_2v2.setBorder(BorderFactory.createLineBorder(new Color(240, 248, 255), 3)); 

        button_2v2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == button_2v2){
                   
                    getContentPane().removeAll();
                    init();
                    third_frame();
                    validate();
                    repaint();
                }
            }
        });
    
        JButton play_with_ai = new JButton("VS PC");
        play_with_ai.setPreferredSize(new Dimension(280, 200)); 
        play_with_ai.setFont(new Font("Arial", Font.BOLD, 50)); 
        play_with_ai.setFocusable(false);
        play_with_ai.setBackground(new Color(144, 238, 144)); 
        play_with_ai.setForeground(new Color(75, 0, 130)); 
        play_with_ai.setBorder(BorderFactory.createLineBorder(new Color(240, 248, 255), 3));

        play_with_ai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == play_with_ai){
                    is_2v2 = false;
                    getContentPane().removeAll();
                    init();
                    second_frame();
                    validate();
                    repaint();
                }
            }
        }); 
    
        
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        innerpanel.add(button_2v2, gbc);
    
        gbc.gridx = 1; 
        gbc.gridy = 0; 
        innerpanel.add(play_with_ai, gbc);
    
        
        outerpanel.add(welcome, BorderLayout.NORTH);
        outerpanel.add(innerpanel, BorderLayout.CENTER);
    
        
        this.add(outerpanel);
    }
    
    private void second_frame() {
        
        JPanel panel = new JPanel();       
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(230, 230, 250)); 
    
        
        JLabel welcome = new JLabel("HI AND WELCOME");
        welcome.setOpaque(true);
        welcome.setFont(font);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setBackground(new Color(144, 238, 144)); 
        welcome.setForeground(new Color(75, 0, 130)); 
        panel.add(welcome, BorderLayout.NORTH);
    
        // Difficulty selection label
        JLabel difficultyLabel = new JLabel("Choose Difficulty Level:");
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 30));
        difficultyLabel.setHorizontalAlignment(JLabel.CENTER);
        difficultyLabel.setForeground(new Color(75, 0, 130)); 
        panel.add(difficultyLabel, BorderLayout.CENTER);
    
        // Difficulty buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10)); 
        buttonPanel.setBackground(new Color(230, 230, 250)); 
    
        
    
        // Button styling
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color buttonColor = new Color(144, 238, 144); 
        Color textColor = new Color(75, 0, 130); 
        
        easyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == easyButton){
                    depth = 1;
                    getContentPane().removeAll();
                    init();
                    third_frame();
                    validate();
                    repaint();
                }
            }
        });

        mediumButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == mediumButton){
                    depth = 3;
                    getContentPane().removeAll();
                    init();
                    third_frame();
                    validate();
                    repaint();
                }
            }
        });

        hardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == hardButton){
                    depth = 5;
                    getContentPane().removeAll();
                    init();
                    third_frame();
                    validate();
                    repaint();
                }
            }
        });

        styleButton(easyButton, buttonFont, buttonColor, textColor);
        styleButton(mediumButton, buttonFont, buttonColor, textColor);
        styleButton(hardButton, buttonFont, buttonColor, textColor);
    
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
    
        panel.add(buttonPanel, BorderLayout.SOUTH);
    
        // Add the main panel to the frame
        add(panel, BorderLayout.CENTER);
    }
    
    private void third_frame() {

        // Title Panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBackground(new Color(75, 0, 130)); 
        game_title.setHorizontalAlignment(JLabel.CENTER);
        game_title.setFont(font);
        game_title.setForeground(new Color(240, 248, 255)); 
        title_panel.add(game_title, BorderLayout.CENTER);
    
        add(title_panel, BorderLayout.NORTH);
    
        // Button Panel
        button_panel.setLayout(new GridLayout(3, 3, 5, 5)); 
        button_panel.setBackground(new Color(25, 25, 25)); 
    
        // Styling Game Buttons
        for (int i = 0; i < 9; i++) {
            game_Buttons[i] = new JButton("");
            game_Buttons[i].setFont(new Font("Arial", Font.BOLD, 100));
            game_Buttons[i].setFocusPainted(false);
            game_Buttons[i].setBackground(new Color(144, 238, 144)); 
            game_Buttons[i].setForeground(new Color(75, 0, 130)); 
            game_Buttons[i].setBorder(BorderFactory.createLineBorder(new Color(240, 248, 255), 3)); 
            game_Buttons[i].addActionListener(this); // Add event listener
            button_panel.add(game_Buttons[i]);
        }
    
        add(button_panel, BorderLayout.CENTER);
    }


    // Helper method to style buttons
    private void styleButton(JButton button, Font font, Color background, Color foreground) {
        button.setFont(font);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }
    

    // Met à jour le tableau actuel avec les valeurs des boutons
    static void current_board() {
        for (int i = 0; i < 9; i++) {
            Buttons[i] = game_Buttons[i].getText();
        }
    }
    

    // Vérifie si le jeu est terminé (match nul ou victoire)
    public static boolean game_over() {
        for (int i = 0; i < 9; i++) {
            if (Buttons[i].equals("")) {
                return false; // Il reste des cases vides
            }
        }
        return true; // Toutes les cases sont remplies
    }

    // Vérifie l'état actuel du jeu (victoire, égalité, ou en cours)
    static int game_state() {
        String symbol = "";
        int[][] patterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Lignes horizontales
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Lignes verticales
                {0, 4, 8}, {2, 4, 6} // Diagonales
        };

        for (int[] pattern : patterns) {
            if (Buttons[pattern[0]].equals(Buttons[pattern[1]]) &&
                Buttons[pattern[0]].equals(Buttons[pattern[2]]) &&
                !Buttons[pattern[0]].equals("")) {
                symbol = Buttons[pattern[0]];
                break;
            }
        }

        if (symbol.equals("X")) {
            return -1; // X gagne
        } else if (symbol.equals("O")) {
            return 1; // O gagne
        } else if (game_over()) {
            return 0; // Match nul
        } else {
            return 2; // Jeu en cours
        }
    }


    // Algorithme minimax pour l'IA
    public static int minimax(int depth, boolean isMaximizing) {
        int result = game_state();
        if (result != 2 || depth == 0) {
            return result; // Si le jeu est terminé ou profondeur maximale atteinte
        }

        if (isMaximizing) {
            int bestScore = -10;
            for (int i = 0; i < 9; i++) {
                if (Buttons[i].equals("")) { 
                    Buttons[i] = "O"; // L'IA joue "O"
                    int score = minimax(depth - 1, false);
                    Buttons[i] = ""; // Annuler le mouvement
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = 10;
            for (int i = 0; i < 9; i++) {
                if (Buttons[i].equals("")) { 
                    Buttons[i] = "X"; // Le joueur humain joue "X"
                    int score = minimax(depth , true);
                    Buttons[i] = ""; // Annuler le mouvement
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    // IA effectuant son tour
    public static void ai_turn() {
            int bestScore = -10;
            int bestMove = -1;
            for (int i = 0; i < 9; i++) {
                if (Buttons[i].equals("")) { // Case vide
                    Buttons[i] = "O"; // L'IA joue "O"
                    int score = minimax(depth, false); 
                    Buttons[i] = ""; // Annuler le mouvement
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = i;
                    }
                }
            }
            Buttons[bestMove] = "O"; // L'IA joue dans la meilleure case qui depend du parametre "depth"
            game_Buttons[bestMove].setText("O"); // Mettre à jour le bouton de l'IA
        }
    
    // Détermine qui commence (l'IA ou le joueur humain)
    public static void first_turn() {
            is_Ai = random.nextInt(2) != 0;
        }
    
    public static void humain_vs_humain(){
       
            if (game_state() == -1) { // Le Joueur 1 gagne : Symbole X
                game_title.setText("PLAYER 1 WON !");
                System.out.println("X Won ");
                
                resetGameWithDelay(2000);
                return;
            } else if (game_state() == 0) { // Match nul
                game_title.setText("TIE!");
                
                resetGameWithDelay(2000);
                
                
                return;   
            }
            else if (game_state() == 1) { // Le Joueur 2 gagne : Symbole O
                game_title.setText("PLAYER 2 WON !");
                
                resetGameWithDelay(2000);   
                return;              
            }
            if(player_1){
                game_title.setText("O Turn");
            }
            else{
                game_title.setText("X Turn");
            }
        }
    
    // Réinitialisation du jeu
    public static void resetGame() {
            game_title.setText("Tic Tac Toe");
            for (int i = 0; i < 9; i++) {
                Buttons[i] = "";
                game_Buttons[i].setText("");
            }
            
            if(!is_2v2){
                first_turn();
                if (is_Ai) {
                    ai_turn();
            }
        }
               
    }


    private static void resetGameWithDelay(int delayMillis) {
        new javax.swing.Timer(delayMillis, e -> {
            resetGame();
            ((javax.swing.Timer) e.getSource()).stop();
        }).start();
    }
    
    // la fonction d'initialisation du Frame 
    private void init(){ 
        setTitle("Tic-Tac-Toe");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(50, 50, 50));
    }
    
    // Le Constructeur de la classe
    public Tic_Tac_Toe() {
        super();
        init();
        first_frame();
       
    }

    // Action de clic sur un bouton
    @Override
    public void actionPerformed(ActionEvent e) {

        if(!is_2v2){ //game VS Comptuer

            for (int i = 0; i < 9; i++) {
                if (e.getSource() == game_Buttons[i] && Buttons[i].equals("")) {
                    game_Buttons[i].setText("X"); // Joueur humain joue "X"
                    Buttons[i] = "X";
                    current_board();

                    if (game_state() == -1) {
                        
                        game_title.setText("YOU WON !");
                        resetGameWithDelay(2000);
                        
                        return;
                    } else if (game_state() == 0) {
                        
                        game_title.setText("IT'S A TIE !");
                        resetGameWithDelay(2000);
                        return;
                    }

                    ai_turn();
                    current_board();

                    if (game_state() == 1) {
                        
                        game_title.setText("TRY AGAIN NETXT TIME!");
                        resetGameWithDelay(2000);
                    } else if (game_state() == 0) {
                        
                        game_title.setText("IT'S A TIE !");
                        resetGameWithDelay(2000);
                    }
                }
            }
        }

        else{ // 2 VS 2
            for(int i =0; i< 9;i++){
                if(e.getSource() == game_Buttons[i] && game_Buttons[i].getText().equals("") ){

                    if(player_1){ // Le premier joueur , Symbole 'X'

                        game_Buttons[i].setText("X");
                        Buttons[i] ="X";
                        current_board();
                        humain_vs_humain();
                        player_1 = false;
                        //game_title.setText("O Turn");

                    }
                    else{ // Le deuxieme joueur , Symbole 'O'

                        game_Buttons[i].setText("O");
                        Buttons[i] = "O";
                        current_board();
                        humain_vs_humain();
                        player_1 = true;
                       //game_title.setText("X Turn");

                    }
                }
            }
        }
        
        
    }
    

    // Méthode principale
    public static void main(String[] args) {

        Tic_Tac_Toe game = new Tic_Tac_Toe();
    game.setVisible(true);

        if(!is_2v2){
            first_turn();
            if (is_Ai) {
                Tic_Tac_Toe.ai_turn();
            }

        }
        
        
    }
}
