import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {

	Queue<Note> notes;

	Melody(Queue<Note> song) {
		notes = new LinkedList<>();
		notes = song;

	}

	double getTotalDuration() {
		double d = 0.0;
		boolean repeat = false;
		Queue<Note> copyQ = new LinkedList<>(notes);
		int size = notes.size();
		for (int i = 0; i < size; i++) {
			Note temp = copyQ.poll();

			if (temp.isRepeat()) {
				repeat = !repeat;

				if (!repeat) {

					d += temp.getDuration();

				}
			}
			if (repeat) {
				d += temp.getDuration() * 2;
			} else {
				d += temp.getDuration();
			}

		}

		return d;
	}

	@Override
	public String toString() {
		Queue<Note> copy = new LinkedList<>(notes);
		String s = "";
		while (!copy.isEmpty()) {

			s += (copy.poll().toString() + "\n");
		}

		return s;

	}

	void changeTempo(double tempo) {
		Queue<Note> copy = new LinkedList<>(notes);

		int size = copy.size();
		for (int i = 0; i < size; i++) {
			Note temp = copy.poll();

			temp.setDuration(temp.getDuration() * tempo);

			copy.offer(temp);
		}
		notes = copy;

	}

	void reverse() {
		Queue<Note> copy = new LinkedList<>(notes);
		Stack<Note> stack = new Stack<>();

		while (!copy.isEmpty()) {
			stack.push(copy.poll());
		}

		while (!stack.isEmpty()) {
			copy.offer(stack.pop());
		}

		notes = copy;

	}

	void append(Melody other) {
		Queue<Note> copyOther = other.getNotes();

		while (!copyOther.isEmpty()) {
			notes.offer(copyOther.poll());
		}

	}

	void play() {

		Queue<Note> repeatQ = new LinkedList<>();
		boolean repeats = false;

		int size = notes.size();
		for (int i = 0; i < size; i++) {

			Note temp = notes.poll();
			temp.play();
			if (temp.isRepeat()) {
				repeats = !repeats;
				if (!repeats) {
					while (!repeatQ.isEmpty()) {
						Note tempR = repeatQ.poll();
						tempR.play();
					}
					temp.play();
				}
			}
			if (repeats) {
				repeatQ.offer(temp);
			}
			notes.offer(temp);
		}

	}

	Queue<Note> getNotes() {

		return notes;
	}

}
