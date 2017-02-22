package edu.neumont.csc150.p0111.connerp.project1.mail;

import java.util.Comparator;

import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Parcel;

public enum MailComparator implements Comparator<Mailable> {
	Distance{
		public int compare(Mailable o1, Mailable o2) {
			int ret = (int) (o1.destination.DistanceFrom(refference.destination) - o2.destination.DistanceFrom(refference.destination));
			return ret;
        }
	},
	Angle{
		public int compare(Mailable o1, Mailable o2) {
            return (int) (o1.destination.AngleFrom(refference.destination) - o2.destination.AngleFrom(refference.destination));
        }	
	},
	LetterFirst{
		public int compare(Mailable o1, Mailable o2) {
			if(o1.getClass().isInstance(o2.getClass())){
				return 0;
			}else if(o1 instanceof Parcel){
	            return 1;
			}else{
	            return -1;
			}
        }
	},
	Mass{
		public int compare(Mailable o1, Mailable o2) {
			if(o1 instanceof Parcel && o2 instanceof Parcel){
				return (int) (((Parcel)o2).GetVolume() - ((Parcel)o1).GetVolume());
			}else{
				return 0;
			}
		}
	};
	
	private static Mailable refference;
	
	public static Comparator<Mailable> decending(Comparator<Mailable> other) {
        return new Comparator<Mailable>() {
            public int compare(Mailable o1, Mailable o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }
	
	public static Comparator<Mailable> getComparator(Mailable reff, MailComparator[] multipleOptions) {
		refference = reff;
        return new Comparator<Mailable>() {
            public int compare(Mailable o1, Mailable o2) {
                for (MailComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}