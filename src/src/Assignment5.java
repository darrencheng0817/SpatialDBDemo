package src;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Polygon;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Ambulance;
import model.Lion;
import model.Pond;
import model.Region;
/**
 * 
 */

/**
 * @author Darren
 *
 */
public class Assignment5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new myFrame();
	}

}

class myFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean checkBoxState = false;
	myPanel panel;

	public myFrame() {
		panel = new myPanel();
		Checkbox cb = new Checkbox("show lions and ponds in the selected region!                                                                               ");
		cb.addItemListener(new checkBoxListener());
		panel.setBackground(Color.BLACK);
		panel.setSize(600, 600);
		panel.addMouseListener(new mouseMoniter());
		GridBagLayout layout=new GridBagLayout();
		this.setLayout(layout);
		this.add(cb);
		
		GridBagConstraints s= new GridBagConstraints();
		s.fill=GridBagConstraints.BOTH;
		s.gridx=0;
		s.gridy=0;
		s.gridheight=1;
		s.gridwidth=0;
		layout.setConstraints(cb, s);
		s.gridx=0;
		s.gridy=GridBagConstraints.RELATIVE;
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=1;
		s.fill=GridBagConstraints.BOTH;
		layout.setConstraints(panel, s);
		this.add(panel,s);
		this.setTitle("Assignment5 Cheng Cheng");
		this.setResizable(false);
		this.setLocation(100, 100);
		this.setSize(550, 570);
		this.setVisible(true);
	}

	class checkBoxListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if (arg0.getStateChange() == ItemEvent.SELECTED) {
				checkBoxState = true;
			}
			if (arg0.getStateChange() == ItemEvent.DESELECTED) {
				checkBoxState = false;
				panel.drawall();
			}
		}
	}

	class mouseMoniter implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (checkBoxState == true)
				panel.showLionAndPond(e.getX(), e.getY());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}
}

class myPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static List<Region> regions;
	private static List<Lion> lions;
	private static List<Pond> ponds;
	private static List<Ambulance> ambulances;
	DataCollector dc;

	public myPanel() {

		regions = new LinkedList<>();
		lions = new LinkedList<>();
		ponds = new LinkedList<>();
		ambulances = new LinkedList<>();
		dc = new DataCollector();
		dc.getRegions(regions);
		dc.getLions(lions);
		dc.getPonds(ponds);
		dc.getAmbulances(ambulances);
	}

	public void paint(Graphics g) {
		DataCollector dc = new DataCollector();
		dc.getRegions(new LinkedList<>());
		Graphics2D g2d = (Graphics2D) g;
		drawRegions(g2d);
		drawLions2(g2d);
		drawPonds(g2d);
		//drawAmbulances(g2d);
	}
	public void drawall(){
		Graphics2D g2d=(Graphics2D) getGraphics();
		drawRegions(g2d);
		drawLions2(g2d);
		drawPonds(g2d);
	}

	private void drawRegions(Graphics2D g2d) {

		for (Region region : regions) {
			Polygon p = new Polygon();
			for (int i = 0; i < region.shape.length; i++) {
				p.addPoint((int) region.shape[i].latitude, (int) region.shape[i].longitude);
			}
			g2d.setColor(Color.WHITE);
			g2d.fillPolygon(p);
			g2d.setColor(Color.BLACK);
			g2d.drawPolygon(p);
		}
	}

	private void drawLions(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		for (Lion lion : lions) {
			g2d.drawLine((int) lion.location.latitude, (int) lion.location.longitude, (int) lion.location.latitude,
					(int) lion.location.longitude);
		}
	}

	private void drawLions2(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		for (Lion lion : lions) {
			Ellipse2D circle2D = new Ellipse2D.Double();
			circle2D.setFrameFromCenter(lion.location.latitude, lion.location.longitude, lion.location.latitude + 2,
					lion.location.longitude + 2);
			g2d.draw(circle2D);
			g2d.fill(circle2D);
		}

	}

	private void drawPonds(Graphics2D g2d) {
		for (Pond pond : ponds) {
			Ellipse2D circle2D = new Ellipse2D.Double();
			circle2D.setFrameFromCenter(pond.center.latitude, pond.center.longitude, pond.center.latitude + pond.radius,
					pond.center.longitude + pond.radius);
			g2d.setColor(Color.BLACK);
			g2d.draw(circle2D);
			g2d.setColor(Color.BLUE);
			g2d.fill(circle2D);
		}
	}

	private void drawAmbulances(Graphics2D g2d) {
		
		g2d.setColor(Color.YELLOW);
		for (Ambulance ambulance : ambulances) {
			Ellipse2D circle2D = new Ellipse2D.Double();
			circle2D.setFrameFromCenter(ambulance.location.latitude, ambulance.location.longitude,
					ambulance.location.latitude + ambulance.coverRaduis,
					ambulance.location.longitude + ambulance.coverRaduis);
			g2d.draw(circle2D);
		}
	}

	private void drawLions(List<Integer> lionIds){
		if(lionIds.size()==0)
			return;
		Graphics2D g2d=(Graphics2D) getGraphics();
		HashSet<Integer> lionsSet=new HashSet<>();
		for(Integer id:lionIds){
			lionsSet.add(id);
		}
		for(Lion lion:lions){
			if(lionsSet.contains(lion.id)){
				g2d.setColor(Color.RED);
				Ellipse2D circle2D = new Ellipse2D.Double();
				circle2D.setFrameFromCenter(lion.location.latitude, lion.location.longitude, lion.location.latitude + 2,
						lion.location.longitude + 2);
				g2d.draw(circle2D);
				g2d.fill(circle2D);
			}
		}
	}
	private void drawPonds(List<Integer> pondIds){
		if(pondIds.size()==0)
			return;
		Graphics2D g2d=(Graphics2D) getGraphics();
		HashSet<Integer> pondsSet=new HashSet<>();
		for(Integer id:pondIds){
			pondsSet.add(id);
		}
		for(Pond pond:ponds){
			if(pondsSet.contains(pond.id)){
				g2d.setColor(Color.RED);
				Ellipse2D circle2D = new Ellipse2D.Double();
				circle2D.setFrameFromCenter(pond.center.latitude, pond.center.longitude, pond.center.latitude + pond.radius,
						pond.center.longitude + pond.radius);
				g2d.draw(circle2D);
				g2d.fill(circle2D);
			}
		}
	}
	private int getRegionId(int x, int y) {
		int res = -1;
		for (Region region : regions) {
			Polygon p = new Polygon();
			for (int i = 0; i < region.shape.length; i++) {
				p.addPoint((int) region.shape[i].latitude, (int) region.shape[i].longitude);
			}
			if (p.contains(x, y))
				return region.id;
		}
		return res;
	}

	public void showLionAndPond(int x, int y) {
		Graphics2D g2d=(Graphics2D) getGraphics();
		drawRegions(g2d);
		drawLions2(g2d);
		drawPonds(g2d);
		int regionId = getRegionId(x, y);
		List<Integer> lionIds = dc.getLionInsideRegion(regionId);
		drawLions( lionIds);
		List<Integer> pondIds = dc.getPondInsideRegion(regionId);
		drawPonds(pondIds);
	}
}
