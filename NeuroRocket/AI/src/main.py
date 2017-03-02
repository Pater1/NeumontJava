from javax.swing import JFrame, JButton, JOptionPane

class MyWindow(JFrame):
	def __init__(self):
		super(MyWindow, self).__init__(windowClosing=self.on_close)
		self.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE)
		
		self.setSize(300,200)
		self.setLocationRelativeTo(None)
		self.setTitle('Title')
		
		selft.button = JButton('Click me', actionPerformed=self.on_click)
		self.add(self.button)
		
	def on_click(self, widget):
		print 'clicked'
		
	def on_close(self, widget):
		if JOptionPane.showConfirmDialog(None, 'Sure you wan to exit?', 'Exit', JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION:
			print 'Bye'
			self.dispose()
			
if __name__ == '__main__':
	win = MyWindow()
	win.setVisible(1)	