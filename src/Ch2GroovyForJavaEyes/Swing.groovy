/**
 * 2.6 实现接口
 */

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.WindowConstants
import java.awt.FlowLayout
import java.awt.event.ActionListener
import java.awt.event.FocusListener
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

frame = new JFrame(size: [300, 300],
        layout: new FlowLayout(),
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)
button = new JButton("click")
positionLabel = new JLabel("")
msgLabel = new JLabel("")
frame.contentPane.add button
frame.contentPane.add positionLabel
frame.contentPane.add msgLabel

// 通过as将代码块转换为接口
button.addActionListener(
        { JOptionPane.showMessageDialog(frame, "You clicked!") } as ActionListener
)

//同一个代码块通过as转换为不同的接口
displayMouseLocation = { positionLabel.setText("$it.x, $it.y") }
frame.addMouseListener(displayMouseLocation as MouseListener)
frame.addMouseMotionListener(displayMouseLocation as MouseMotionListener)

// 接口中不需要实现所有的方法，如果未实现方法不会被调用的话
// 若调用了未实现的方法，则会空指针异常
// 其本质应该是调用方法时去map中按方法名查找实现
handleFocus = [
        focusGained: { msgLabel.setText("Good to see you!") },
        focusLost  : { msgLabel.setText("Come back soon!") }
]
button.addFocusListener(handleFocus as FocusListener)

// 用于运行时才知道接口类型
events = ['WindowListener', 'ComponentListener']
handler = { msgLabel.setText("$it") }
for (event in events) {
    handleImpl = handler.asType(Class.forName("java.awt.event.$event"))
    frame."add$event"(handleImpl) // 字符串会转换为方法调用
}

frame.show()
