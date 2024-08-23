translate ([0, 0, 15]) {
  rotate (a=90.0, v=[0, 1, 0]) {
    union () {
      difference () {
        cube ([8, 20.5, 72.5], center=true);
        cube ([1000, 18.5, 70.5], center=true);
      }
      translate ([0, 13.25, 0]) {
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
      translate ([0, -13.25, 0]) {
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
