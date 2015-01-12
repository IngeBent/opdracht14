//
//  WelcomeScene.m
//  game
//
//  Created by Inge van Benthem on 04-12-14.
//  Copyright (c) 2014 Inge van Benthem. All rights reserved.
//


#import "WelcomeScene.h"
#import "GameScene.h"

@interface WelcomeScene ()
@property BOOL sceneCreated;
@end

@implementation WelcomeScene

- (void) didMoveToView:(SKView *)view
{
    
    if (!self.sceneCreated)
    {
        self.backgroundColor = [SKColor blackColor];
        self.scaleMode = SKSceneScaleModeAspectFill;
        [self addChild: [self createWelcomeNode]];
        
        self.sceneCreated = YES;
        
    }
}

- (SKLabelNode *) createWelcomeNode
{
   SKLabelNode *welcomeNode =
    [SKLabelNode labelNodeWithFontNamed:@"Bradley Hand"];
    
    welcomeNode.name = @"welcomeNode";
    welcomeNode.text = @"Verzamel zo veel mogelijk vissen binnen 2 minuten, tab voor start";
    welcomeNode.fontSize = 32;
    welcomeNode.fontColor = [SKColor whiteColor];
    
    welcomeNode.position =
    CGPointMake(CGRectGetMidX(self.frame), CGRectGetMidY(self.frame));
    
     return welcomeNode;

    
}


- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    SKNode *welcomeNode = [self childNodeWithName:@"welcomeNode"];
    
    if (welcomeNode != nil)
    {
        SKAction *fadeAway = [SKAction fadeOutWithDuration:1.0];
        
        [welcomeNode runAction:fadeAway completion:^{
            SKScene *archeryScene =
            [[GameScene alloc]initWithSize:self.size];
            
            SKTransition *doors =
            [SKTransition doorwayWithDuration:1.0];
            
            [self.view presentScene:archeryScene transition:doors];
        }
         ];
    }
}
@end