translate ([0, 0, 21]) {
  rotate (a=90.0, v=[0, 1, 0]) {
    union () {
      difference () {
        cube ([8, 29.7, 65.2], center=true);
        cube ([1000, 27.7, 63.2], center=true);
      }
      translate ([0, 17.85, 0]) {
        rotate (a=90.0, v=[1, 0, 0]) {
          union () {
            translate ([0, -8, 0]) {
              cube ([8, 6, 6], center=true);
            }
            translate ([0, 8, 0]) {
              cube ([8, 6, 6], center=true);
            }
          }
        }
      }
      translate ([0, -17.85, 0]) {
        rotate (a=90.0, v=[1, 0, 0]) {
          union () {
            translate ([0, -8, 0]) {
              cube ([8, 6, 6], center=true);
            }
            translate ([0, 8, 0]) {
              cube ([8, 6, 6], center=true);
            }
          }
        }
      }
    }
  }
}
