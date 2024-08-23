color ([0.2, 0.2, 0.2, ]) {
  translate ([0, 0, 3]) {
    cube ([44, 44, 6], center=true);
  }
}
color ([0.9, 0.9, 0.9, ]) {
  translate ([0, 0, 15]) {
    rotate (a=90.0, v=[0, 1, 0]) {
      cube ([18, 18, 70], center=true);
    }
  }
}
color ([0.44, 0.84, 0.15, ]) {
  translate ([0, 0, 15]) {
    rotate (a=90.0, v=[0, 1, 0]) {
      union () {
        difference () {
          cube ([8, 20.2, 72.2], center=true);
          cube ([1000, 18.2, 70.2], center=true);
        }
        translate ([0, 13.1, 0]) {
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
        translate ([0, -13.1, 0]) {
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
}
