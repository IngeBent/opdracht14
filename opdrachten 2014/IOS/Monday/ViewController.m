//
//  ViewController.m
//  Monday
//
//  Created by Inge van Benthem on 10-09-14.
//  Copyright (c) 2014 Inge van Benthem. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

//later:

//random getal voor aantal vissen in het scherm
//teller wanneer je een vis pakt
//bommetje = af wanneer je deze raakt


-(void)Collison{
    
    //wanneer de rondje en onderkant of bovenkant elkaar raken dan is het einde game.
    if(CGRectIntersectsRect(rond1.frame, top.frame)){
        [self endGame];
    }
    
    if (CGRectIntersectsRect(rond1.frame, bottom.frame)){
        [self endGame];
    }
    
    if (CGRectIntersectsRect(rond1.frame, vis1.frame)){
        vis1.hidden = YES;
        [self scoring];
    }
    
    if (CGRectIntersectsRect(rond1.frame, vis2.frame)){
        vis2.hidden = YES;
    
        [self scoring];
    }
    
    if(rond1.center.y < 84){
        [self endGame];
    }
    
    if(rond1.center.y > 418){
        [self endGame];
    }
    
}


-(void)endGame{
    
    //wanneer je iets raakt, rondje hidden en na 5 seconden wordt de selector new game gestart
    rond1.hidden = YES;
    [timer invalidate];
  // [scoreTimer invalidate];
    
    [self performSelector:@selector(newGame) withObject:(nil) afterDelay:5];
    
    
    
}

-(void)newGame{
    
    vis1.hidden = YES;
    vis2.hidden = YES;
    
   
    
    intro1.hidden = NO;
    intro2.hidden = NO;
    intro3.hidden = NO;
    
    rond1.hidden = NO;
    
    rond1.center = CGPointMake(96, 228);
    rond1.image = [UIImage imageNamed:@"bol1.png"];
    
    Start = YES;
    scoreNumber = 0;
    
    score.text = [NSString stringWithFormat:@"score: 0"];
}

-(void)rondjeMove{
    
    [self Collison];
    
    rond1.center = CGPointMake(rond1.center.x, rond1.center.y + Y);
    
    //vissen gaan telkens een stukje naar links (beweging)
    vis1.center = CGPointMake(vis1.center.x -10, vis1.center.y);
    vis2.center = CGPointMake(vis2.center.x -10, vis2.center.y);
    
    
    //wanneer de vis links uit het scherm is, verschijnt er een nieuwe vis
    if(vis1.center.x <0){
        randomPosition = arc4random() %300;
        randomPosition = randomPosition + 110;
        vis1.hidden = NO;
        //zet de x op 570 en de y op random position
        vis1.center = CGPointMake(300, randomPosition);
        
    }
    
    if(vis2.center.x <0){
        randomPosition = arc4random() %300;
        randomPosition = randomPosition + 110;
        vis2.hidden = NO;
        //zet de x op 570 en de y op random position
        vis2.center = CGPointMake(420, randomPosition);
        
    }
    
   
    
}

-(void)scoring{

    scoreNumber = scoreNumber + 1;
    score.text = [NSString stringWithFormat:@"score is: %i", scoreNumber];
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    //deze code wordt gestart wanneer je ergens op het scherm drukt
    //hier moeten verschillende dingen in, aangezien de eerste keer dta je het scherm aanraakt er iets anders moet gebeuren dan wanneer je hem voor de 2e keer aanraakt.
    
    if(Start == YES){
        intro1.hidden = YES;
        intro2.hidden = YES;
        intro3.hidden = YES;
        vis1.hidden = NO;
        vis2.hidden = NO;
       // rond2.hidden = NO;
    
        
        //75 random getal hier tussen gevonden.(tussen de vlakken waar het moet komen) Je moet plus 110 doen, anders begint het bovenaan het scherm met tellen.
        randomPosition = arc4random() %300;
        randomPosition = randomPosition + 110;
        
        //zet de x op 570 en de y op random position
        vis1.center = CGPointMake(300, randomPosition);
        
        randomPosition = arc4random() %300;
        randomPosition = randomPosition + 110;
        
        //zet de x op 570 en de y op random position
        vis2.center = CGPointMake(420, randomPosition);
        
        
        
        timer = [NSTimer scheduledTimerWithTimeInterval:0.1 target:self selector:@selector(rondjeMove) userInfo:nil repeats:YES];
        
       // scoreTimer = [NSTimer scheduledTimerWithTimeInterval:1 target:self selector:@selector(scoring) userInfo:nil repeats:YES];
        
        Start = NO;
        
        
    }
    
    
    
    Y = -7;
    
}




-(void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{//deze code wordt gestart wanneer we niet meer het scherm aanraken.
    
    Y = 7;
    
}


- (void)viewDidLoad
{
    //verteld spel te starten met start
   // rond2.hidden = YES;
    vis1.hidden = YES;
    vis2.hidden = YES;
    Start = YES;
    [super viewDidLoad];
    
    
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
