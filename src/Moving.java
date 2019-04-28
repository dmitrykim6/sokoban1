//public class Moving {
//    private int currentPosition;
//    private int newPosition;
//    private int behind;
//    private int stepUp;
//    private int oldPosition;
//    private int index;
//
//    Moving(int currentPosition, int newPosition, int behind, int stepUp, int index){
//
//        this.currentPosition = currentPosition;
//        this.newPosition = newPosition;
//        this.behind = behind;
//        this.stepUp = stepUp;
//        this.index = index;
//
//        this.oldPosition = oldPosition;
//
//
//        if(currentPosition == 1){
//            if (newPosition == 0){
//                currentPosition = 0;
//                index = stepUp;
//                currentPosition = 1;
//            }
//            else if (newPosition == 4){
//                currentPosition = 0;
//                index = stepUp;
//                currentPosition = 5;
//            }
//            else if (newPosition == 3){
//                if(behind == 0) {
//                    currentPosition = 0;
//                    index = stepUp;
//                    currentPosition = 1;
//                    newPosition = 3;
//                }
//                else if(behind == 4) {
//                    currentPosition = 0;
//                    index = stepUp;
//                    currentPosition = 1;
//                    newPosition = 6;
//                }
//            }
//            else if (newPosition == 6){
//                if(behind == 0) {
//                    currentPosition = 0;
//                    index = stepUp;
//                    currentPosition = 5;
//                    newPosition = 3;
//                }
//                else if(behind == 4) {
//                    currentPosition = 0;
//                    index = stepUp;
//                    currentPosition = 5;
//                    newPosition = 6;
//                }
//            }
//        }
//        else if(currentPosition == 5){
//            if (newPosition == 0){
//                currentPosition = 4;
//                index = stepUp;
//                currentPosition = 1;
//            }
//            else if (newPosition == 4){
//                currentPosition = 4;
//                index = stepUp;
//                currentPosition = 5;
//            }
//            else if (newPosition == 3){
//                if(behind == 0) {
//                    currentPosition = 4;
//                    index = stepUp;
//                    currentPosition = 1;
//                    newPosition = 3;
//                }
//                else if(behind == 4) {
//                    currentPosition = 4;
//                    index = stepUp;
//                    currentPosition = 5;
//                    newPosition = 6;
//                }
//            }
//            else if (newPosition == 6){
//                if(behind == 0) {
//                    currentPosition = 4;
//                    index = stepUp;
//                    currentPosition = 5;
//                    newPosition = 3;
//                }
//                else if(behind == 4) {
//                    currentPosition = 4;
//                    index = stepUp;
//                    currentPosition = 5;
//                    newPosition = 6;
//                }
//            }
//        }
//    }
//}