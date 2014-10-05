//
//  ViewController.h
//  Monday
//
//  Created by Inge van Benthem on 10-09-14.
//  Copyright (c) 2014 Inge van Benthem. All rights reserved.
//

#import <UIKit/UIKit.h>
int Y;
BOOL Start;
int randomPosition;
int scoreNumber;
int higScore;



@interface ViewController : UIViewController

{
    IBOutlet UILabel *intro1;
    IBOutlet UILabel *intro2;
    IBOutlet UILabel *intro3;
    IBOutlet UIImageView *rond1;
    IBOutlet UIImageView *vis1;
    IBOutlet UIImageView *vis2;
    IBOutlet UIImageView *top;
    IBOutlet UIImageView *bottom;
    NSTimer *timer;
    
    IBOutlet UILabel *score;
    NSTimer *scoreTimer;
}

-(void)rondjeMove;
-(void)Collison;
-(void)endGame;
-(void)newGame;
-(void)scoring;

@end
