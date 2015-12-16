package kata7;

import application.swing.HistogramPanel;
import application.swing.ToolBar;
import control.CalculateCommand;
import control.Command;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import view.AttributeDialog;
import view.HistogramDisplay;
import view.PopulationDialog;

public class Application extends JFrame {
    
    private Map<String,Command> commands = new HashMap<>();
    private AttributeDialog attributteDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay display;

    public Application() {
        this.deployUI();
        this.createCommands();
    }
    
    
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    private void deployUI() {
        this.setTitle("Histogram viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolBar(),BorderLayout.NORTH);
    }

    private void createCommands() {
        commands.put("calculate", new CalculateCommand(attributteDialog, populationDialog, display));
    }

    private HistogramPanel histogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.display = panel;
        return panel;
    }

    private JPanel toolBar() {
        ToolBar panel = new ToolBar(commands);
        this.attributteDialog = panel;
        this.populationDialog = panel;
        return panel;
    }
    
}
