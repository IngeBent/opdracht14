//
//  GameScene.m
//  game
//
//  Created by Inge van Benthem on 04-12-14.
//  Copyright (c) 2014 Inge van Benthem. All rights reserved.
//

@import CoreMotion;


#import "GameScene.h"
#import "FMMParallaxNode.h"

//komen 15 vissen op
#define kNumVis   15




@implementation GameScene
{
     SKLabelNode *startGame;

    
    FMMParallaxNode *_parallaxNodeBackgrounds;
    FMMParallaxNode *_parallaxSpaceDust;
    

    
    //vissen:
    NSMutableArray *_vissen;
    int _nextVissen;
 
    //score
    SKLabelNode *_scoreLabel;
    double _nextVissenSpawn;
    
    //timer
    SKLabelNode *_timerLabel;
    
  
   
}

-(id)initWithSize:(CGSize)size {
    
    
    if (self = [super initWithSize:size]) {
        
        self.backgroundColor = [SKColor colorWithRed:0.2265625f green:0.30078125f blue:0.49609375f alpha:1.0f];
        
      //  self.backgroundColor = [NSColor colorWithDeviceRed:0.2265625f green:0.30078125f blue:0.49609375f alpha:1.0f];
    
        /*an RGB of (226, 226, 226) could be instantiated as a NSColor using the values:
         
         Red: (226 +1)/256 = 0.886
         Green: (226 +1)/256 = 0.886
         Blue: (226 +1)/256 = 0.886*/
        
        
        
#pragma mark - Game Backgrounds
        
        //1
        NSArray *parallaxBackgroundNames = @[@"water1.png", @"water3.png",
                                             @"water4.png", @"water5.png"];
        CGSize waterSizes = CGSizeMake(200.0, 200.0);
        //2
        _parallaxNodeBackgrounds = [[FMMParallaxNode alloc] initWithBackgrounds:parallaxBackgroundNames
                                                                           size:waterSizes
                                                           pointsPerSecondSpeed:10.0];
        //3
        _parallaxNodeBackgrounds.position = CGPointMake(size.width/2.0, size.height/2.0);
        //4
        [_parallaxNodeBackgrounds randomizeNodesPositions];
        
        //5
        [self addChild:_parallaxNodeBackgrounds];
        
        //6
        NSArray *parallaxBackground2Names = @[@"waterAchtergrond2.png",@"waterAchtergrond2.png"];
        _parallaxSpaceDust = [[FMMParallaxNode alloc] initWithBackgrounds:parallaxBackground2Names
                                                                     size:size
                                                     pointsPerSecondSpeed:25.0];
        _parallaxSpaceDust.position = CGPointMake(0, 0);
        [self addChild:_parallaxSpaceDust];
        
        
 //settup scorelabel:
        
        _scoreLabel = [SKLabelNode labelNodeWithFontNamed:@"DIN Alternate"];
        _scoreLabel.position = CGPointMake(15, 10);
        _scoreLabel.horizontalAlignmentMode = SKLabelHorizontalAlignmentModeLeft;
        _scoreLabel.fontSize = 25;
        
        [self addChild:_scoreLabel];
      
        
        //settup timer label
        _timerLabel = [SKLabelNode labelNodeWithFontNamed:@"DIN Alternate"];
        _timerLabel.position = CGPointMake(130, 10);
        _timerLabel.horizontalAlignmentMode = SKLabelHorizontalAlignmentModeLeft;
        _timerLabel.fontSize = 25;
        
        
        [self addChild:_timerLabel];
        
     
        
        
#pragma mark - TBD - Setup the vis
        
            
           _vissen = [[NSMutableArray alloc] initWithCapacity:kNumVis];
            for (int i = 0; i < kNumVis; ++i) {
                //geeft aantal vissen aan
                
                
                
                SKSpriteNode *vissen = [SKSpriteNode spriteNodeWithImageNamed:@"vis1.png"];//geel2.png
                
                vissen.hidden = YES;
                //image size:
                [vissen setXScale:0.23];
                [vissen setYScale:0.23];
                
                
                [_vissen addObject:vissen];
                [self addChild:vissen];
            }
        
#pragma mark - TBD - Setup the stars
        [self addChild:[self loadEmitterNode:@"stars1"]];
        [self addChild:[self loadEmitterNode:@"stars2"]];
        [self addChild:[self loadEmitterNode:@"stars3"]];
        
#pragma mark - TBD - Start the ame
        [self startTheGame];
        
    }
    return self;
}

//stars:

- (SKEmitterNode *)loadEmitterNode:(NSString *)emitterFileName
{
    NSString *emitterPath = [[NSBundle mainBundle] pathForResource:emitterFileName ofType:@"sks"];
    SKEmitterNode *emitterNode = [NSKeyedUnarchiver unarchiveObjectWithFile:emitterPath];
    
    //do some view specific tweaks
    emitterNode.particlePosition = CGPointMake(self.size.width/2.0, self.size.height/2.0);
    emitterNode.particlePositionRange = CGVectorMake(self.size.width+100, self.size.height);
    
    return emitterNode;
}

- (void)startCountdown
{
    _counter = 120;
    
    NSTimer *timer = [NSTimer scheduledTimerWithTimeInterval:1
                                                      target:self
                                                    selector:@selector(countdownTimer:)
                                                    userInfo:nil
                                                     repeats:YES];
}

- (void)countdownTimer:(NSTimer *)timer
{
    _counter--;
    if (_counter <= 0) {
        [timer invalidate];
        
        [self end];
    }
    
   
    
    if(_counter == 0 ){
         _timerLabel.text = [NSString stringWithFormat:@"Einde"];
    }
    else{
         _timerLabel.text = [NSString stringWithFormat:@"Timer: %d", _counter ];
    }
}


//einde game
-(void)end
{
    _vissen.removeAllObjects;
    //crasht de app, heb nog niet het einde van een app en het opnieuw starten er van. Vandaar de crash, zodat de app toch stopt na 2 minuten
    
    
}


-(void)newVis
{
    
    
    int b = 0;
  
    for (b = 0; b < 5; b++) {
        SKSpriteNode *vissen = [SKSpriteNode spriteNodeWithImageNamed:@"vis1.png"];//geel2.png
        
        vissen.hidden = YES;
        [vissen setXScale:0.23];
        [vissen setYScale:0.23];
        [_vissen addObject:vissen];
        [self addChild:vissen];
    }
}

-(void)setScore:(int)score
{
    _score = score;
    _scoreLabel.text = [NSString stringWithFormat:@"score = %d", score];
    if(_counter == 0)
    {
        
    }
}


- (void)startTheGame
{
    _nextVissenSpawn = 0;
      self.score = 0;
    
    for (SKSpriteNode *vissen in _vissen) {
        vissen.hidden = YES;
    }
    
      [self startCountdown];

 
    
}


- (float)randomValueBetween:(float)low andValue:(float)high {
    return (((float) arc4random() / 0xFFFFFFFFu) * (high - low)) + low;
}

-(void)update:(NSTimeInterval)currentTime {
    
    //beweging achtergrond:
   [_parallaxSpaceDust update:currentTime];
    
    //beweging achtergrond plaatjes
   [_parallaxNodeBackgrounds update:currentTime];
    
    double curTime = CACurrentMediaTime();

    if (curTime > _nextVissenSpawn) {
        
        
        float randSecs = [self randomValueBetween:0.20 andValue:1.0];
        _nextVissenSpawn = randSecs + curTime;
        
        float randY = [self randomValueBetween:0.0 andValue:self.frame.size.height];
        float randDuration = [self randomValueBetween:2.0 andValue:10.0];
        
        
        SKSpriteNode *vissen = [_vissen objectAtIndex:_nextVissen];
        _nextVissen++;
        
        if (_nextVissen >= _vissen.count) {
            _nextVissen = 0;
        }
        
        [vissen removeAllActions];
        vissen.position = CGPointMake(self.frame.size.width+vissen.size.width/2, randY);
        vissen.hidden = NO;
        
        CGPoint location = CGPointMake(-self.frame.size.width-vissen.size.width, randY);
        
        SKAction *moveAction = [SKAction moveTo:location duration:randDuration];
        SKAction *doneAction = [SKAction runBlock:(dispatch_block_t)^() {
           
            vissen.hidden = YES;
        }];
        
        SKAction *moveVisActionWithDone = [SKAction sequence:@[moveAction, doneAction ]];
        [vissen runAction:moveVisActionWithDone withKey:@"vissenMoving"];
    }
}



-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
    CGPoint location = [[touches anyObject] locationInNode:self];
    
    NSArray *nodes = [self nodesAtPoint:location];
    
    if ([nodes count] == 0){
       
    } else {
      
   

        
        //remove
        [[self children] enumerateObjectsUsingBlock:^(id obj, NSUInteger idx, BOOL *stop) {
            SKNode *node = (SKNode *)obj;
            
            NSLog(@"node.name=%@ %f %f",node.name,node.position.y,node.position.x);
            
            if(node.position.y > location.y -25 && node.position.y < location.y +25
               && node.position.x > location.x -25 && node.position.x < location.x +25 ){
                [node removeFromParent];
               
                //geluid
                      [self runAction:[SKAction playSoundFileNamed:@"Fish2.wav" waitForCompletion:NO]];
                //nieuwe vissen erbij
              
                    [self newVis];
                //score optellen
                self.score ++;
            }
            
            
        }];
        
        
        
        
        
    }
}



@end

